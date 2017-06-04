package cucumber.steps;

import com.github.albertofaci.spring_boot_sample_cucumber.GreetingResource;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * XXX: Note that in this example you are obtaining the GreetingResource from the same Spring context the application is
 * running on. Therefore the resource method call is a plain function call and does not go over HTTP.
 */
@CucumberStepsDefinition
public class GreetingSteps {

    @Autowired
    private GreetingResource greetingResource;
    
    private String name;
    private String result;

    @Given("^a user with name \"([^\"]*)\"$")
    public void a_user_with_name(String name) throws Throwable {
       this.name = name;
    }

    @When("^a greeting is requested$")
    public void the_greeting_service_is_called() throws Throwable {
        result = greetingResource.sayHello(name);
    }


    @Then("^the message is \"([^\"]*)\"$")
    public void the_message_is(String expectedMessage) throws Throwable {
        assertThat(result, is(expectedMessage));
    }


}
