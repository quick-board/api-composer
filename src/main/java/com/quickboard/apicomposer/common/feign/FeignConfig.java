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
        log.info("headerPropagationInterceptor 나 태어났어");
        return new HeaderPropagationInterceptor();
    }
}
