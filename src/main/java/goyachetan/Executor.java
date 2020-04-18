package goyachetan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Executor
{
    public static void main( String[] args )
    {

        SpringApplication.run(Executor.class,args);
        //System.out.println("Enter the query:" + "\n");
        //Scanner sc = new Scanner(System.in);
//        String[] arrOfInputs = new String[5];
//
//        for(int i=0;i<5;i++){
//            arrOfInputs[i] = sc.nextLine();
//        }
//
//        String inputQuery = arrOfInputs[0];
//        String inputQuery1=arrOfInputs[1];
//        String inputQuery2=arrOfInputs[2];
//        String inputQuery3=arrOfInputs[3];
//        String inputQuery4=arrOfInputs[4];
//
//        SearchService ss = new SearchService();
//        SearchServiceThread searchServiceThread= new SearchServiceThread(ss,inputQuery);
//        SearchServiceThread searchServiceThread1= new SearchServiceThread(ss,inputQuery1);
//        SearchServiceThread searchServiceThread2= new SearchServiceThread(ss,inputQuery2);
//        SearchServiceThread searchServiceThread3= new SearchServiceThread(ss,inputQuery3);
//        SearchServiceThread searchServiceThread4= new SearchServiceThread(ss,inputQuery4);
//        searchServiceThread.start();
//        searchServiceThread1.start();
//        searchServiceThread2.start();
//        searchServiceThread3.start();
//        searchServiceThread4.start();
    }
}
