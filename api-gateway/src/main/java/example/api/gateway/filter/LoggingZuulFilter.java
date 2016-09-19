package example.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class LoggingZuulFilter extends ZuulFilter {

    private static final Object NULL = new Object();
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        final RequestContext requestContext = RequestContext.getCurrentContext();
        final HttpServletRequest request = requestContext.getRequest();
        LOGGER.debug("request-uri: {}", request.getRequestURI());
        return NULL;
    }
}
