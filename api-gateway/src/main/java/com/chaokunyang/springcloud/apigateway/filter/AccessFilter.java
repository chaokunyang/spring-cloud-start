package com.chaokunyang.springcloud.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangck
 * @create 2017-02-14 15:49
 */
public class AccessFilter extends ZuulFilter {

    private final Logger logger = LogManager.getLogger(getClass());

    @Override
    public String filterType() {
        return "pre"; // pre、routing、post、error共四种
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
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            logger.warn("access token is empty");
            requestContext.setSendZuulResponse(false); // 令zuul过滤该请求，不对其进行路由
            requestContext.setResponseStatusCode(401);
            return null;
        }

        logger.info("access token ok");
        return null;
    }
}
