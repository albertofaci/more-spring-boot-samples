package com.github.albertofaci.spring_boot_sample_cucumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingResource {

    @Autowired
    private GreetingFactory greetingFactory;

    @GetMapping("/greet")
    public String sayHello(@RequestParam("name") String name) {
        return greetingFactory.createGreeting(name);
    }

}
