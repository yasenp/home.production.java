package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Yassen on 3/29/2016.
 */
public  class GetBy {

    public static WebDriver driver = null;
    public static WebElement element = null;

    public  GetBy(WebDriver driver){
        this.driver = driver;
    }

    public static WebElement GetWebElement(String text, String elementid, String elementclass){

        element = driver.findElement(By.id(text));
        if(text == null){
        element = driver.findElement(By.id(elementid));
            if(elementid == null){
                element = driver.findElement(By.id(elementclass));
            }
        }
        return element;
    }
}
