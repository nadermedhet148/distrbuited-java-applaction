package com.javaDist.gateway.Services;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "AuthService", url = "auth-service")
public interface AuthService {

//    @RequestMapping(method = RequestMethod.GET, value = "/au/test")
//    String getSessionId(@RequestHeader("X-Auth-Token") String token);

}