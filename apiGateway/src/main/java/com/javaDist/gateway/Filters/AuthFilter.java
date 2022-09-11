package com.javaDist.gateway.Filters;

import com.javaDist.gateway.Services.AuthService;
import com.javaDist.gateway.Services.DTO.User;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public class AuthFilter extends ZuulFilter {

    @Autowired
    AuthService authService;


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

        return requestContext.getRequest().getHeader(HttpHeaders.AUTHORIZATION) != null;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        try {
            HttpServletRequest request = requestContext.getRequest();

            requestContext.put(HttpHeaders.AUTHORIZATION, requestContext.getRequest().getHeader(HttpHeaders.AUTHORIZATION));
            User user = this.authService.getUser(requestContext.getRequest().getHeader(HttpHeaders.AUTHORIZATION));
            requestContext.put("X-USER_ID", user.getId());
            return null;
        } catch (
                Exception e
        ) {
            throw new ZuulException(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());

        }
    }
}
