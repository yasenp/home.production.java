package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Yassen on 3/29/2016.
 */
public class JenkinsHome {

    public WebDriver driver = null;

    public JenkinsHome(WebDriver driver){

        this.driver = driver;
    }

    public WebElement logOutHeader = GetBy.GetWebElement("log out", null, null);
    public WebElement newitem = GetBy.GetWebElement("New Item", null, null);

    public void ClickLogOut(){
        this.logOutHeader.click();
    }
}
