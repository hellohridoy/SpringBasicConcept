package com.example.system.springbasicconcept.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @RequestMapping("/")
    private String HelloWorld(){
        return "Hello World";
    }
}
