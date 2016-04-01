package selenium; /**
 * Created by Yassen on 2/16/2016.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestSelenium {


    @Before

    public void openFirefox() {

    }


    @After

//    @Test
//    public void seleniumTest() {
//        WebDriver driver = new FirefoxDriver();
//        driver.navigate().to("http://www.vesti.bg");
//        Assert.assertEquals("Vesti.bg - новини от България и света", driver.getTitle());
//        driver.findElement(By.linkText("Начало")).click();
//        driver.findElement(By.linkText("България")).click();
//        driver.findElement(By.linkText("Свят")).click();
//        driver.findElement(By.linkText("Пари")).click();
//        driver.findElement(By.linkText("Развлечения")).click();
//        driver.findElement(By.linkText("Технологии")).click();
//        driver.findElement(By.linkText("Здравословно")).click();
//        driver.findElement(By.linkText("Последни")).click();
//        driver.findElement(By.linkText("Галерии")).click();
//        driver.quit();
//    }

//    @Test
//    public  void seleniumTestbyID() {
//
//        WebDriver driver = new FirefoxDriver();
//        driver.navigate().to("http://www.vesti.bg");
//        WebElement mainMenu = driver.findElement(By.linkText("България"));
//        mainMenu.click();
//        driver.findElement(By.cssSelector(".nav-main-holder-inner>ul:nth-child(2)>li:nth-child(3)>a:nth-child(1)")).click();
//
////    }
//    @Test
//    public  void seleniumTestbyID() {
//
//        WebDriver driver = new FirefoxDriver();
//        driver.navigate().to("http://www.vesti.bg");
//        WebElement mainMenu = driver.findElement(By.linkText("България"));
//        mainMenu.click();
//        driver.findElement(By.cssSelector(".nav-main-holder-inner>ul:nth-child(2)>li:nth-child(3)>a:nth-child(1)")).click();
//
//    }


    @Test

    public void AbvTestwithSelenium() {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.abv.bg");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBut"));
        username.sendKeys("automation.tests");
        password.sendKeys("automationtests");
        loginButton.click();


    }


}
