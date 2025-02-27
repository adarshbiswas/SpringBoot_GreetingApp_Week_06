package com.greetingapp.greeting.controller;

import com.greetingapp.greeting.dto_model.UserDTO;
import com.greetingapp.greeting.entities.GreetingEntity;
import com.greetingapp.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/greeting/hello")
public class GreetingServiceController {


    private final GreetingService greetingService;

    @Autowired
    //constructor based Dependency injection
    public GreetingServiceController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting() {
        return greetingService.getGreetingMessage();
    }

    @GetMapping("/name")
    public String getCustomGreetingMessage(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return greetingService.customGreetingMessage(firstName, lastName);
    }

    @PostMapping("/post")
    public String getCustomGreetingMessageWithPost(@RequestBody UserDTO user) {
        return greetingService.customGreetingMessage(user.getFirstName(), user.getLastName());
    }

    // Save Greeting Message
    @PostMapping("/save")
    public GreetingEntity saveGreeting(@RequestBody String message) {
        return greetingService.saveGreeting(message);
    }

    // Get Greeting by ID
    @GetMapping("/{id}")
    public Optional<GreetingEntity> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

// List all Greeting Messages
    @GetMapping("/list")
    public List<GreetingEntity> getAllMessages() {
        return greetingService.getAllMessages();
    }

}
