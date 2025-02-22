package com.greetingapp.greeting.dto;

public class Greeting {

    //define attributes
    private String message;


    //define constructor
    public Greeting(String message) {
        this.message = message;
    }

    //use getter and setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
