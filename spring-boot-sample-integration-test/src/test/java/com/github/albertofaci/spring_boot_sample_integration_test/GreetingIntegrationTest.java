package com.github.albertofaci.spring_boot_sample_integration_test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("integration")
@SpringBootTest(classes = {Application.class, TestConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingIntegrationTest {

    @Autowired
    GreetingResource greetingResource;

    @Test
    public void retrieveGreeting() throws Exception {
        String johnsGreeting = greetingResource.sayHello("John");
        assertThat(johnsGreeting, is("TEST MESSAGE: Hello John. How's it going?"));
    }
}
