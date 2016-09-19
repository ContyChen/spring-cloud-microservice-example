package example.common.logging;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import java.io.Serializable;

@EnableConfigurationProperties(LoggingApplicationRunnerConfiguration.LoggingApplicationRunnerProperties.class)
public class LoggingApplicationRunnerConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "example.common.logging-application-runner", name = "enabled", havingValue = "true", matchIfMissing = true)
    public LoggingApplicationRunner loggingApplicationRunner(LoggingApplicationRunnerProperties properties) {
        return new LoggingApplicationRunner(properties.applicationName);
    }

    @ConfigurationProperties(prefix = "example.common.logging-application-runner")
    public static class LoggingApplicationRunnerProperties implements Serializable, InitializingBean {
        private boolean enabled = true;
        private String applicationName = null;

        @Override
        public void afterPropertiesSet() throws Exception {
            Assert.hasLength(applicationName);
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getApplicationName() {
            return applicationName;
        }

        public void setApplicationName(String applicationName) {
            this.applicationName = applicationName;
        }
    }
}
