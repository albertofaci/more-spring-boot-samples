package cucumber.steps;

import com.github.albertofaci.spring_boot_sample_cucumber.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = {Application.class}, loader = SpringBootContextLoader.class)
@RunWith(SpringRunner.class)

@ActiveProfiles("integration")
public @interface CucumberStepsDefinition {
}

