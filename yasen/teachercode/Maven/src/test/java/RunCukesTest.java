import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        features = {"classpath:features/Logout.feature"},
        format = {"json:target/1.json", "pretty"},
        tags = {"@complete"})

public class RunCukesTest {
}