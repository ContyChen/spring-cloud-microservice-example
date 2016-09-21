package example.api.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplicationBoot {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGatewayApplicationBoot.class).web(true).run(args);
    }

}
