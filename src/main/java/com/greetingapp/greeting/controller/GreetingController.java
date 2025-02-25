package com.greetingapp.greeting.controller;

import com.greetingapp.greeting.dto_model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping   //returns a simple greeting
    public Greeting getGreeting() {
        return new Greeting("Hello from BridgeLabz!!");
    }

    @PostMapping("/custom")  //create a greeting message
    public Greeting postGreeting(@RequestBody Greeting greet) {
        return new Greeting("Hello " + greet.getMessage() + " from BridgeLabz!!");
    }

    @PutMapping("/update")  //update a greeting message
    public Greeting updateGreeting(@RequestBody Greeting greet) {
        return new Greeting("Message updated: " + greet.getMessage());
    }

    @DeleteMapping("/delete") //delete a greeting message
    public Greeting deleteGreeting() {
        return new Greeting("Message deleted successfully");
    }
}