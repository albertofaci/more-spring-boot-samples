package com.github.albertofaci.spring_boot_sample_cucumber;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingConfiguration {

    @Value("${greeting.message}")
    String message;

    @Bean
    GreetingFactory greetingFactory() {
        return new GreetingFactory(message);
    }
}
