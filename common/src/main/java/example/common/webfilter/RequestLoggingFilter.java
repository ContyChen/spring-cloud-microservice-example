package example.common.webfilter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public final class RequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggingFilter.class);

    private static final String BARS = StringUtils.repeat('=', 120);

    private final PathMatcher pathMatcher = new AntPathMatcher();
    private final Set<String> excludes = new HashSet<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (excludes.parallelStream().noneMatch(pattern -> pathMatcher.match(pattern, uri))) {
            doLog(request);
        }

        filterChain.doFilter(request, response);
    }

    private void doLog(HttpServletRequest request) {
        LOGGER.debug(BARS);

        LOGGER.debug("[URI]: ");
        LOGGER.debug("\t\t\t{}", request.getRequestURI());

        LOGGER.debug("[METHOD]: ");
        LOGGER.debug("\t\t\t{}", request.getMethod());

        LOGGER.debug("[HEADERS]: ");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            LOGGER.debug("\t\t\t{} = {}", name, name.equalsIgnoreCase("cookie") ? StringUtils.abbreviate(value, 60) : value);
        }

        LOGGER.debug("[PARAMS]: ");
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            String value = request.getParameter(name);
            LOGGER.debug("\t\t\t{} = {}", name, value);
        }

        LOGGER.debug(BARS);
    }

    public RequestLoggingFilter addExcludePattern(String pattern) {
        if (pattern != null && !pattern.isEmpty()) {
            excludes.add(pattern);
        }
        return this;
    }

    public RequestLoggingFilter addExcludePatterns(String... patterns) {
        for (String pattern : patterns) {
            addExcludePattern(pattern);
        }
        return this;
    }

    public RequestLoggingFilter clearExcludes() {
        excludes.clear();
        return this;
    }

    public Set<String> getExcludes() {
        return Collections.unmodifiableSet(excludes);
    }

}
