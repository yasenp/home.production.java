package selenium.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Yassen on 3/13/2016.
 */
public class BasePageObjects {

    WebDriver driver = null;
    WebElement element = null;


    public BasePageObjects(){ driver = new FirefoxDriver(); driver.get("https://jira.atlassian.com/secure/Dashboard.jspa");}


    private WebElement navigateToLogIn(){

        return element = driver.findElement(By.cssSelector("#user-options > a"));

    }

    private WebElement loginElement(){

        return element = driver.findElement(By.cssSelector("#username"));

    }

    private WebElement passwordElement(){

        return element = driver.findElement(By.cssSelector("#password"));

    }

    private WebElement logInButton(){

        return element = driver.findElement(By.cssSelector("#login-submit"));

    }

    public void loginTo(String username, String password){

        navigateToLogIn().click();
        loginElement().sendKeys(username);
        passwordElement().sendKeys(password);
        logInButton().click();

    }

}
