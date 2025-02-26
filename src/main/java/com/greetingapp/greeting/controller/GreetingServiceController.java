package com.greetingapp.greeting.controller;

import com.greetingapp.greeting.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting/hello")
public class GreetingServiceController {

    //private attribute
    private final GreetingService greetingService;

    //constructor based Dependency injection
    public GreetingServiceController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting(){
        return greetingService.getGreetingMessage();
    }

}
