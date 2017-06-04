package com.github.albertofaci.spring_boot_sample_integration_test;

import org.springframework.context.annotation.Bean;

public class GreetingFactory {

    private final String message;

    public GreetingFactory(String message) {
        this.message = message;
    }

    public String createGreeting(String name) {
        return String.format("Hello %s. %s", name, message);
    }
}
