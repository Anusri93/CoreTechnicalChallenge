import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.challenge.*"})
@EnableScheduling
public class Application {
	private static final Logger logger = LogManager.getLogger("commons-log");
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder){ 
        return routeLocatorBuilder.routes() 
                        .route("primary",r->r.path("/api/verve/**") 
                                .uri("http://localhost:8081/")) 
                        .route("secondary",r->r.path("/api/verve/**") 
                                .uri("http://localhost:8082/")).build(); 
    } 

}
