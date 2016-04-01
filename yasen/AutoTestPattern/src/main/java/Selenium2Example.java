import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.net.EphemeralPortRangeDetector;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yassen on 3/8/2016.
 */
public class Selenium2Example {


    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);

        //And now use this to visit Google.
        driver.get("http://www.google.com");
        //Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        //Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        //Enter something to search for
        element.sendKeys("Cheese!");
        element.submit();

        //Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //Google's search is rendered dynamically with JavaScrip.
        //Wait for the page to load, timeout ofter 10 seconds.
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){return d.getTitle().toLowerCase().startsWith("cheese!");
            } });


        try {
            java.io.File scrFile =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(scrFile, new java.io.File("C:\\snapshot\\screenshot.png"));
        } catch(Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}

