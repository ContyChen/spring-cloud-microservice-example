package example.common.util;

import org.springframework.context.annotation.Bean;

public class SpringUtilsConfiguration {

    @Bean
    public SpringUtils springUtils() {
        return new SpringUtils();
    }

}
