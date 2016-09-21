package example.common.applicationrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class LoggingApplicationRunner implements ApplicationRunner, Ordered, EnvironmentAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingApplicationRunner.class);
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final String applicationName;
    private Environment env;

    public LoggingApplicationRunner(String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.debug("-------------------------------------------------------");
        LOGGER.debug("[application-name]");
        LOGGER.debug("\t\t{}", applicationName);
        LOGGER.debug("[startup]");
        LOGGER.debug("\t\t{}", DATE_FORMAT.format(new Date()));
        LOGGER.debug("[profiles]");
        LOGGER.debug("\t\t{}", Arrays.asList(env.getActiveProfiles()));
        LOGGER.debug("-------------------------------------------------------");
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
