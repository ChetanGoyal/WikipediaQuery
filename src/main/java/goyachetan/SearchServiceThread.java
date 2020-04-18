package goyachetan;

public class SearchServiceThread extends Thread {

    private SearchService searchService;
    private String inputQuery;

    public SearchServiceThread(SearchService searchService, String inputQuery){
        this.searchService = searchService;
        this.inputQuery = inputQuery;
    }

    /*public void run(){
        searchService.getResult(inputQuery);
    }*/
}
