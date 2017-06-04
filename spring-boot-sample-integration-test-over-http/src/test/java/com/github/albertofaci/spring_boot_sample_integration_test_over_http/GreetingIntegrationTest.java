package com.github.albertofaci.spring_boot_sample_integration_test_over_http;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("integration")
@SpringBootTest(classes = {Application.class, TestConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingIntegrationTest {

    @LocalServerPort
    int serverPort;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void retrieveGreeting() throws Exception {
        ResponseEntity<String> johnsGreetingResponse = greet("John");
        assertThat(johnsGreetingResponse.getStatusCode(), is(HttpStatus.OK));
        assertThat(johnsGreetingResponse.getBody(), is("TEST MESSAGE: Hello John. How's it going?"));
    }

    private ResponseEntity<String> greet(String name) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:" + serverPort)
                .path("/greet")
                .queryParam("name", name)
                .build().toUri();
        return testRestTemplate.getForEntity(uri, String.class);
    }
}
