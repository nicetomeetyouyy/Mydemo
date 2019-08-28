import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableCaching
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30)
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.xjm.demo.control")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
