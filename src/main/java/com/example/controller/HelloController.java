package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, ZZQ";
    }

    @PostMapping("/hello")
    public String hello(@RequestBody String hello) {
        return hello;
    }
}