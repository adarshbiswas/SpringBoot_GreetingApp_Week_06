package com.greetingapp.greeting.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "greetings")
public class GreetingEntity {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    // Constructors
    public GreetingEntity() {
    }

    public GreetingEntity(String message) {
        this.message = message;
    }

}
