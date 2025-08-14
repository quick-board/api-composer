package com.quickboard.apicomposer.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/composition/v1")
public class TestController {

    @GetMapping("/tests/hello-world")
    public String helloWorld(){
        return "hello world";
    }
}
