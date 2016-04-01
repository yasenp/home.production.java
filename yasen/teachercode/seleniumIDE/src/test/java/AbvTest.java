import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbvTest {

    protected WebDriver driver = new FirefoxDriver();

    protected WebElement findElement(By by) throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(by);
    }

    @Test
    public void testingAbv() throws InterruptedException {

        //WebDriver driver = null;

        driver.get("http://www.abv.bg/");

        findElement(By.id("username")).clear();

        findElement(By.id("username")).sendKeys("automation.tests");
        findElement(By.id("password")).clear();
        findElement(By.id("password")).sendKeys("automationtests");
        findElement(By.id("loginBut")).click();
        findElement(By.cssSelector("div > div.fl")).click();
        findElement(By.cssSelector("div.abv-button")).click();
        findElement(By.cssSelector("input.fl")).click();
        findElement(By.cssSelector("input.fl")).clear();
        findElement(By.cssSelector("input.fl")).sendKeys("shtraker@abv.bg");
        findElement(By.cssSelector("input.gwt-TextBox")).clear();
        findElement(By.cssSelector("input.gwt-TextBox")).sendKeys("test");
        findElement(By.cssSelector("div.abv-button")).click();
        findElement(By.cssSelector("div > div.fl")).click();

        driver.quit();

    }
}
