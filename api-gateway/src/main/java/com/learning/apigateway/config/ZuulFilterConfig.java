package com.learning.apigateway.config;

import com.learning.apigateway.filter.AddResponseHeaderFilter;
import com.learning.apigateway.filter.RateLimiterFilter;
import com.learning.apigateway.filter.TokenFilter;
import com.netflix.discovery.util.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFilterConfig {

    /*@Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }*/

    @Bean
    public AddResponseHeaderFilter addResponseHeaderFilter() {
        return new AddResponseHeaderFilter();
    }

    @Bean
    public RateLimiterFilter rateLimiterFilter() {
        return new RateLimiterFilter();
    }

}
