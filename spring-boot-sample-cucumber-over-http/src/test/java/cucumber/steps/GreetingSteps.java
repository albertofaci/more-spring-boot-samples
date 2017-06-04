package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@CucumberStepsDefinition
public class GreetingSteps  {

    @LocalServerPort
    protected Integer serverPort;

    @Autowired
    private TestRestTemplate testRestTemplate;
    
    private String name;
    private ResponseEntity<String> result;

    @Given("^a user with name \"([^\"]*)\"$")
    public void a_user_with_name(String name) throws Throwable {
       this.name = name;
    }

    @When("^a greeting is requested$")
    public void the_greeting_service_is_called() throws Throwable {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:"+serverPort)
                .path("/greet")
                .queryParam("name", name)
                .build().toUri();
        result = testRestTemplate.getForEntity(uri, String.class);
    }

    @Then("^the greeting is successful$")
    public void the_greeting_is_successful() throws Throwable {
        assertThat(result.getStatusCode(), is(HttpStatus.OK));
    }

    @Then("^the message is \"([^\"]*)\"$")
    public void the_message_is(String expectedMessage) throws Throwable {
        assertThat(result.getBody(), is(expectedMessage));
    }


}
