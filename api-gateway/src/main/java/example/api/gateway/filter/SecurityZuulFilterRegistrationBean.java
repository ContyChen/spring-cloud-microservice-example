package example.api.gateway.filter;

import com.netflix.zuul.filters.FilterRegistry;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class SecurityZuulFilterRegistrationBean implements ApplicationRunner, Ordered {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final FilterRegistry filterRegistry = FilterRegistry.instance();
        filterRegistry.put(SecurityZuulFilter.class.getSimpleName(), new SecurityZuulFilter());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

}
