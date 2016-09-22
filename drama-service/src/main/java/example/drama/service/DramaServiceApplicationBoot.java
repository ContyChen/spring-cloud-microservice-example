package example.drama.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DramaServiceApplicationBoot {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DramaServiceApplicationBoot.class).web(true).run(args);
    }

}
