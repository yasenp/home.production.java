import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoogleTest {

    public static void main(String[ ] args) throws IOException, InterruptedException {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver( );
        driver.manage( ).timeouts( ).implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.manage( ).timeouts( ).pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage( ).timeouts( ).setScriptTimeout(100,TimeUnit.SECONDS);
        driver.manage( ).window( ).maximize( );
        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate( ).to("http://www.google.com");
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys("Cheese!");
        element.submit( );
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle( ));
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>( ) {
        public Boolean apply(WebDriver d) {
            return d.getTitle( ).toLowerCase( ).startsWith("cheese!");
        }   }   );
        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle( ));

        WebElement myDynamicElement =
                (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.presenceOfElementLocated(
                                By.id("myDynamicElement")));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element2 =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("someid")));

        Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

        java.io.File scrFile =
                ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new java.io.File("D:\\screenshot.png"));


        // Close the browser
        driver.quit( );
    }
}



