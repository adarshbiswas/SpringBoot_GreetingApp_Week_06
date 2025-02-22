package com.greetingapp.greeting.controller;


import com.greetingapp.greeting.GreetingApplication;
import com.greetingapp.greeting.dto.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping   //returns a simple greeting
    public Greeting getGreeting() {
        return new Greeting("Hello from BridgeLabz!!");
    }

    @PostMapping("/custom")  //create a greeting message
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Hello " + greeting.getMessage() + " from BridgeLabz!!");
    }

    @PutMapping("/update")  //update a greeting message
    public Greeting updateGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Message updated: " + greeting.getMessage());
    }

    @DeleteMapping("/delete") //delete a greeting message
    public Greeting deleteGreeting() {
        return new Greeting("Message deleted successfully");
    }
}