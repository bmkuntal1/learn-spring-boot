package com.bmkuntal.springbootjsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello world! Welcome to spring-boot project";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        return "<h1>Hello world! Welcome to spring-boot project</h1>";
    }

    //http://localhost:8080/say-hello-jsp?name=Mukund
    @RequestMapping("say-hello-jsp")
    public String sayHelloJSP(@RequestParam String name, ModelMap model){
        model.put("name", name);
        return "say-hello";
    }
}
