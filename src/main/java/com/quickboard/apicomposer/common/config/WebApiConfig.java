package com.quickboard.apicomposer.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebApiConfig {

    @Value("${services.post.url}")
    public String postUrl;
    @Value("${services.board.url}")
    public String boardUrl;
    @Value("${services.comment.url}")
    public String commentUrl;
    @Value("${services.profile.url}")
    public String profileUrl;

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }

    @Bean("postWebClient")
    public WebClient postWebClient(WebClient.Builder webClientBuilder){
        return webClientBuilder.baseUrl(postUrl).build();
    }

    @Bean("boardWebClient")
    public WebClient boardWebClient(WebClient.Builder webClientBuilder){
        return webClientBuilder.baseUrl(boardUrl).build();
    }

    @Bean("commentWebClient")
    public WebClient commentWebClient(WebClient.Builder webClientBuilder){
        return webClientBuilder.baseUrl(commentUrl).build();
    }

    @Bean("profileWebClient")
    public WebClient profileWebClient(WebClient.Builder webClientBuilder){
        return webClientBuilder.baseUrl(profileUrl).build();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
