package goyachetan;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that has a getQuery method that will take in an input query and return the
 * response by calling off the wikipedia URL with required params.
 */
@RestController
public class SearchService {

    /**
     * Method will take in the input string and execute the url to the response
     * and then convert it in to JSON and then parse it to put the title and full url in the map.
     * @param String : inputString
     * @return Map<String,String>
     */

    @ResponseBody
    @RequestMapping(value = "query", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @QueryParam("inputQuery")
    public Map<String,String> getResult(String inputString){

        Map<String,String> map = new HashMap<>();

        /*
        2: Making sure that there are no special character in the input string.
            Will use regex to replace all special characters with space.
         */

        inputString = inputString.replaceAll("[^a-zA-Z0-9]", " ");
        try {
            String text = "";
            /*
            Below URL will take the resultant string and execute it to get the response.
             */
            URL url =
                    new URL("https://en.wikipedia.org/w/api.php?action=query&generator=search&gsrsearch="+
                            inputString.replace(" ", "%20")+"&inprop=url&prop=info&format=json&origin=*");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
                String line = null;
                while (null != (line = br.readLine())) {
                    line = line.trim();
                    if (true) {
                        text += line;
                    }
                }
            }
            /*
            This will get the response in to Json format and the parse it.
            Sample JSON is :
                        "pages": {
                            "36517": {
                                        "touched": "2020-04-16T15:27:08Z",
                                         "ns": 0,
                                        "canonicalurl": "https://en.wikipedia.org/wiki/The_Who",
                                        "contentmodel": "wikitext",
                                        "fullurl": "https://en.wikipedia.org/wiki/The_Who",
                                        "pagelanguagehtmlcode": "en",
                                        "length": 142553,
                                        "index": 8,
                                        "pageid": 36517,
                                        "title": "The Who",
                                        "lastrevid": 949982438,
                                        "pagelanguage": "en",
                                        "pagelanguagedir": "ltr",
                                        "editurl": "https://en.wikipedia.org/w/index.php?title=The_Who&action=edit"
                                    }
                                 }
             */
            JSONObject json = new JSONObject(text);
            int count =0;
            if(json.has("query")){
                JSONObject query = json.getJSONObject("query");
                JSONObject pages = query.getJSONObject("pages");
                for(String key: pages.keySet()) {
                    JSONObject page = pages.getJSONObject(key);
                /*
                We are concerned with title and full URL as it is required by the user.
                if any other parameters is required from the json, we can modify accordingly
                 */
                    String title = page.getString("title");
                    String fullUrl = page.getString("fullurl");
                    map.put(fullUrl,title);
                    count++;
                    if(count == 3){
                        break;
                    }
                }
            }else{
                System.out.println("For input string " + inputString +" no results are found");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        if(map.size()>0){
            return map;
        }else{
            map.put("Empty Result","No Data Exists");
            return map;
        }
    }
}
