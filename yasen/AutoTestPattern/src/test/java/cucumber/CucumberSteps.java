package cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by Yassen on 2/20/2016.
 */
public class CucumberSteps {


    public WebDriver driver;

    @Before
    public void buildDriver(){
        driver = new FirefoxDriver();
        driver.get("http://jira.atlassian.com");
    }

    @After
    public void destroyDriver() {driver.quit();}


    @Given("^user account login in jira (.*) and (.*)$")
    public void user_account_login_in_jira(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.cssSelector(".login-link"));
        login.click();
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.cssSelector("#username"));
        username.sendKeys("name");
        Thread.sleep(5000);
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("pass");
        Thread.sleep(5000);
        WebElement loginSubmit = driver.findElement(By.cssSelector("#login-submit"));
        loginSubmit.click();
        Thread.sleep(10000);
    }

    @When("^the user logaout from jira$")
    public void the_user_logaout_from_jira() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^the user successfully jira$")
    public void the_user_successfully_jira() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}