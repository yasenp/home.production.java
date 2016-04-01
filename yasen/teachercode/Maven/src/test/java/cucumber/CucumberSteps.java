package cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CucumberSteps {

    public WebDriver driver;

    @Before
    public void buildDriver() {
        driver = new FirefoxDriver();
        driver.get("http://jira.atlassian.com");
    }

    @After
    public void destroyDriver() {
        driver.quit();
    }

    @Given("^user account login in jira$")
    public void user_account_login_in_jira() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user account login in jira");
        Thread.sleep(10000);
    }

    @When("^the user logout from jira$")
    public void the_user_logout_from_jira() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("the user logout from jira");
    }

    @Then("^the user successfully logout from jira$")
    public void the_user_successfully_jira() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("the user successfully jira");
    }


    @When("^go to Add issue$")
    public void go_to_Add_issue() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^add issue with (.*), (.*) and (.*)$")
    public void add_issue_with_Test_test_and_test(String tittle,String env,String description) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^verify that the issue is created successfully$")
    public void verify_that_credits_charged_with_money_euro() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }



}
