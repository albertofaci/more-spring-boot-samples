package com.github.albertofaci.spring_boot_sample_integration_test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfiguration {

    @Value("${greeting.message}")
    String message;

    /**
     * Perhaps we want to override the GreetingFactory defined in the GreetingConfiguration.java to have some
     * test-specific behaviour. The @Primary annotation will ensure that the bean in this class will take precedence
     * @return GreetingFactory
     */
    @Bean
    @Primary
    GreetingFactory testGreetingFactory() {
        return new GreetingFactory(message) {

            @Override
            public String createGreeting(String name) {
                return String.format("TEST MESSAGE: Hello %s. %s", name, message);
            }

        };
    }
}
