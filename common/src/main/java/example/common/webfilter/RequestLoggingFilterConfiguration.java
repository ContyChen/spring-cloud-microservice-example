package example.common.webfilter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(RequestLoggingFilterConfiguration.RequestLoggingFilterProperties.class)
public class RequestLoggingFilterConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "example.common.request-logging-filter", name = "enabled", havingValue = "true", matchIfMissing = true)
    public FilterRegistrationBean reuqestLoggingFilter(RequestLoggingFilterProperties properties) {
        final RequestLoggingFilter filter = new RequestLoggingFilter();

        if (!properties.getExcludes().isEmpty()) {
            filter.clearExcludes();
            properties.getExcludes().forEach(filter::addExcludePattern);
        }

        final FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(filter);
        bean.setEnabled(properties.enabled);
        bean.setOrder(properties.filterOrder);
        bean.addUrlPatterns(properties.urlPatterns);
        bean.setName(properties.filterName);
        return bean;
    }

    @ConfigurationProperties(prefix = "example.common.request-logging-filter")
    public static class RequestLoggingFilterProperties implements Serializable {

        private boolean enabled = true;
        private String filterName = RequestLoggingFilter.class.getSimpleName();
        private int filterOrder = Ordered.LOWEST_PRECEDENCE;
        private String[] urlPatterns = new String[]{"/*"};
        private Set<String> excludes = new HashSet<>();

        public RequestLoggingFilterProperties() {
            excludes.add("/**/*.ico");
            excludes.add("/**/*.js");
            excludes.add("/**/*.css");
            excludes.add("/**/*.gif");
            excludes.add("/**/*.png");
            excludes.add("/**/*.bmp");
            excludes.add("/**/*.jpg");
            excludes.add("/**/*.ico");
            excludes.add("/*.ico");
        }

        public Set<String> getExcludes() {
            return excludes;
        }

        public void setExcludes(Set<String> excludes) {
            this.excludes = excludes;
        }
    }
}
