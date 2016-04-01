import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        features = {"classpath:features/JenkinsFunct.feature"},
        format = {"json:target/1.json", "pretty"},
        tags = {"@one","@two"})

public class RunCukesTest {
}