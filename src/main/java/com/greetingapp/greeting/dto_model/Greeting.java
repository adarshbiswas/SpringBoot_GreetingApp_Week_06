package com.greetingapp.greeting.dto_model;

import lombok.Getter;
import lombok.Setter;


public class Greeting {

    //use getter and setter
    //define attributes
    private String message;

    //define constructor
    public Greeting(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
