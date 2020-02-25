package com.didispace;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * description: AccessFilter <br>
 * date: 2020/1/3 9:54 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
public class AccessFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

    @Override
    /**
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。<br>
     *   这里定义为pre，代表会在请求被路由之前执行。
     */
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    /**
     * 判断该过滤器是否需要被执行。
     * 这里我们直接返回了true，因此该过滤器对所有请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围。
     */
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.warn("access token is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");

        return null;
    }
}
