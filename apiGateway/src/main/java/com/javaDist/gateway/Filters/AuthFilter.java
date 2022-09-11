package com.javaDist.gateway.Filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;

public class AuthFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 3;

    }

    @Override
    public boolean shouldFilter() {

        RequestContext requestContext = RequestContext.getCurrentContext();

//        return requestContext.getRequest().getHeader(HttpHeaders.AUTHORIZATION) != null;
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

//        System.out.println(requestContext.getRequest().getHeader(USER_HEADER));
        requestContext.put(HttpHeaders.AUTHORIZATION, requestContext.getRequest().getHeader(HttpHeaders.AUTHORIZATION));

        return null;
    }
}
