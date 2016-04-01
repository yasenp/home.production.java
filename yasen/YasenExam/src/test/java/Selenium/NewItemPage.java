package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Yassen on 3/29/2016.
 */
public class NewItemPage {

    public WebDriver driver = null;

    public NewItemPage(WebDriver driver){

        this.driver = driver;
    }


    public WebElement itemname = GetBy.GetWebElement(null, "#name", null);
    public WebElement freestyleproject = GetBy.GetWebElement("Freestyle project", null, null);
    public WebElement mavenproject = GetBy.GetWebElement("Maven project", null, null);
    public WebElement externaljob = GetBy.GetWebElement("External Job", null, null);
    public WebElement multiconfproject = GetBy.GetWebElement("Multi-configuration project", null, null);
    public WebElement copyexistingitem = GetBy.GetWebElement("Copy existing Item", null, null);
    public WebElement copyfrom = GetBy.GetWebElement(null, "#from", null);

}
