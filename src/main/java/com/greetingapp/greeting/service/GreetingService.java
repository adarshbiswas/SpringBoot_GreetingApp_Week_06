package com.greetingapp.greeting.service;

import com.greetingapp.greeting.dto_model.Greeting;
import com.greetingapp.greeting.entities.GreetingEntity;
import com.greetingapp.greeting.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    // Constructor-based Dependency Injection
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage() {
        return "Hello World";
    }

    public String customGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + "!!";
        } else if (firstName != null) {
            return "Hello " + firstName + "!!";
        } else if (lastName != null) {
            return "Hello " + lastName + "!!";
        } else {
            return "Hello World";
        }
    }

    public Greeting getGreetingById(long id) {
        return null;
    }


    // Save Greeting Message
    public GreetingEntity saveGreeting(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }

    // Get Greeting Message by ID
    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

//    Get all Greeting Messages in the Repository
    public List<GreetingEntity> getAllMessages() {
        return greetingRepository.findAll();
    }
}
