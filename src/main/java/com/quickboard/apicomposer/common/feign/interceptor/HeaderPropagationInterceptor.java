package com.quickboard.apicomposer.common.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Slf4j
public class HeaderPropagationInterceptor implements RequestInterceptor {

    private static final List<String> allowedHeaders = List.of("passport");

    @Override
    public void apply(RequestTemplate requestTemplate) {
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            allowedHeaders.forEach(key -> {
                String value = request.getHeader(key);
                requestTemplate.header(key, value);
            });

        }catch (NullPointerException e){
            log.info("request is null ={}", e.getMessage());
        }

    }
}
