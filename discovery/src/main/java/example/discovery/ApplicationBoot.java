package example.discovery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationBoot.class).web(true).run(args);
    }

}
