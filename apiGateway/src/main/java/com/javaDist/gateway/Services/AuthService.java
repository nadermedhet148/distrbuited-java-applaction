package com.javaDist.gateway.Services;

import com.javaDist.gateway.Services.DTO.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.HttpHeaders;

@FeignClient(name = "auth-service")
public interface AuthService {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    User getUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token);

}