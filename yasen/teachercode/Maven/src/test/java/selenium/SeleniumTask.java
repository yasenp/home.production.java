package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * Created by Deni on 16.2.2016 г..
 */
public class SeleniumTask {

    @Test
    public void seleniumTest() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.vesti.bg/");
        driver.findElement(By.linkText("Начало")).click();
        driver.findElement(By.className("#menu-zdravoslovno > span:nth-child(1) > a:nth-child(1)"));
        Thread.sleep(10000);
        String var = driver.findElement(By.tagName("BODY")).getText();
        System.out.println(var);
        driver.findElement(By.linkText("България")).click();
        driver.findElement(By.linkText("Свят")).click();
        driver.findElement(By.linkText("Пари")).click();
        driver.quit();

    }

}
