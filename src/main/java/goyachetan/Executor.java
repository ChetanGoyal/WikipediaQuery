package goyachetan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class Executor consists of main method responsible for
 * running the application and taking the input via REST and returning the
 * response back to the USER.
 */

@SpringBootApplication
public class Executor
{
    public static void main( String[] args )
    {
        SpringApplication.run(Executor.class,args);
    }
}
