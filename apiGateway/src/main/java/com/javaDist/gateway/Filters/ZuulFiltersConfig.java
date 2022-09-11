package com.javaDist.gateway.Filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFiltersConfig {
    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }
}