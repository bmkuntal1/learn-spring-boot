package com.bmkuntal.restapi.controllers;

import com.bmkuntal.restapi.models.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("hello-world")
    public String helloWorld(){
        return "Hello World from API!";
    }

    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("This is response from bean");
    }
}
