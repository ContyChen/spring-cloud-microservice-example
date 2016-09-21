package example.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

public class SecurityZuulFilter extends ZuulFilter {

    private static final Object NULL = new Object();
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityZuulFilter.class);
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String AUTHORIZATION_HEADER = "Basic " + Base64.encodeBase64String((USERNAME+ ":" + PASSWORD).getBytes(Charset.forName("UTF-8")));

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
        final RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("Authorization", AUTHORIZATION_HEADER);
        LOGGER.trace("设置请求头 {}:{} (uri: {})", "Authorization", AUTHORIZATION_HEADER, ctx.getRequest().getRequestURI());
        // YWRtaW46YWRtaW4=
        return NULL;
    }

}
