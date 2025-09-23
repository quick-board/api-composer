package com.quickboard.apicomposer.common.feign;

import com.quickboard.apicomposer.common.feign.interceptor.HeaderPropagationInterceptor;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FeignConfig {
    @Bean
    public RequestInterceptor headerPropagationInterceptor(){
        return new HeaderPropagationInterceptor();
    }
}
