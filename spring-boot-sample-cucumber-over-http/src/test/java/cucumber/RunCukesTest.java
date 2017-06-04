package cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Cucumber Test runner (JUnit).
 * If you get "java.lang.NoClassDefFoundError: org/dom4j/DocumentException" it means that the steps are not "glued"
 * properly. You must define the 'glue' attribute of @CucumberOptions if your features are in a different package
 * from your Steps.
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = {"~@Ignore"}, glue = "cucumber.steps")
public class RunCukesTest {
}
