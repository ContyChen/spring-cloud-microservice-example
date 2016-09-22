package example.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SpringUtils implements ApplicationContextAware, EnvironmentAware {

    private static ApplicationContext APP_CTX;
    private static Environment ENV;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.APP_CTX = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        SpringUtils.ENV = environment;
    }

    public static ApplicationContext getApplicationContext() {
        return APP_CTX;
    }

    public static Environment getEnvironment() {
        return ENV;
    }

    public static List<String> getProfiles() {
        return Arrays.asList(getEnvironment().getActiveProfiles());
    }

    public static Set<String> getProfilesAsSet() {
        return new HashSet<>(getProfiles());
    }

}
