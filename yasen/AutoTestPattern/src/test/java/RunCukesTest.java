/**
 * Created by Yassen on 2/20/2016.
 */


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(strict = true,
        features = {"classpath:features/Logout.feature"},
        format = {"pretty","html:target/cucumber"},
        tags = {"@complete"})

public class RunCukesTest {


}
