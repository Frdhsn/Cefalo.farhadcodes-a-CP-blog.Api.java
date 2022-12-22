package com.springapi.farhadcodesacpblog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World from blog api backend. Work In Progress.";
    }
}
