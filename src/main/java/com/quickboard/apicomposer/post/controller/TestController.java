package com.quickboard.apicomposer.post.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/composition/v1")
public class TestController {

    private final WebClient webClient;

    public TestController(@Qualifier("postWebClient")WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/tests/hello-world")
    public String helloWorld(){
        return "hello world";
    }

    @GetMapping("/boards/{id}/posts")
    public Mono<String> getPosts(@PathVariable("id") Long boardId){
        return webClient.get().uri("/rsc/v1/boards/" + boardId + "/posts")
                .retrieve()
                .onStatus(code -> code.is4xxClientError(),
                        resp -> resp.bodyToMono(String.class).map(RuntimeException::new))
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(2));
    }
}
