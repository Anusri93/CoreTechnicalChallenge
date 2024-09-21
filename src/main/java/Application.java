
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
 
@SpringBootApplication
@ComponentScan(basePackages = {"com.challenge.*"})
@EnableScheduling
public class Application extends SpringBootServletInitializer {
 
  //private static final Logger LOGGER = LogManager.getLogger(Application.class);
	private static final Logger logger = LogManager.getLogger("commons-log");
 
  public static void main(String[] args)
    {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
         
        logger.info("Info level log message");
        logger.debug("Debug level log message");
        logger.error("Error level log message");
       // System.out.println("Hello");
    }
}