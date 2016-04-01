package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Yassen on 3/29/2016.
 */
public class LoginPage{

    public WebDriver driver = null;

    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement userName = GetBy.GetWebElement(null, "#j_username", null);
    public WebElement passWord = GetBy.GetWebElement(null, "#j_password", null);
    public WebElement rememberCheckBox = GetBy.GetWebElement(null, "#remember_me", null);
    public WebElement logInButton = GetBy.GetWebElement(null, "#yui-gen1-button", null);
    public WebElement logInHeader = GetBy.GetWebElement("log in", null, null);
    public WebElement searchBox = GetBy.GetWebElement(null, "#searchform", null);


    public void setUserName() {
        this.userName.clear();
        this.userName.sendKeys(WebConstatnts.UserName());
    }

    public void setPassWord(){
        this.userName.clear();
        this.passWord.sendKeys(WebConstatnts.PassWord());
    }


    public void clickLoginButton(){
        this.logInButton.click();
    }

    public JenkinsHome Login(){
        setUserName();
        setPassWord();
        clickLoginButton();

        return PageFactory.initElements(driver, JenkinsHome.class);
    }
}
