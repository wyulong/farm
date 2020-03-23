import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author xhua
 * @Date 2020/1/2 17:11
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.farm"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
