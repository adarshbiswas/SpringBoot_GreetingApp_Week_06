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

    //    Update a message by it's ID
    public GreetingEntity updateGreeting(Long id, String message) {
        Optional<GreetingEntity> existingGreeting = greetingRepository.findById(id);

        if (existingGreeting.isPresent()) {
            GreetingEntity greeting = existingGreeting.get();
            greeting.setMessage(message);

            return greetingRepository.save(greeting);
        }
        return null;
    }

    //    Delete a message by ID
    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
