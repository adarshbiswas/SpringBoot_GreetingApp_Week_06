package com.greetingapp.greeting.controller;

import com.greetingapp.greeting.dto_model.UserDTO;
import com.greetingapp.greeting.service.GreetingService;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/name")
    public String getCustomGreetingMessage(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        return greetingService.customGreetingMessage(firstName,lastName);
    }

    @PostMapping("/post")
    public String getCustomGreetingMessageWithPost(@RequestBody UserDTO user){
        return greetingService.customGreetingMessage(user.getFirstName(), user.getLastName());
    }
}
