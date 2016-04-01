package selenium.seleniumPageFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PageFactory_Example {

    static WebDriver driver;

    Home_PG_POF HomePage;

    LogIn_PG_POF LoginPage;

    @Before

    public void beforeMethod() {

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.store.demoqa.com");

        HomePage = PageFactory.initElements(driver, Home_PG_POF.class);

        LoginPage = PageFactory.initElements(driver, LogIn_PG_POF.class);

    }

    @Test

    public void test() throws InterruptedException {

        HomePage.lnk_MyAccount.click();

        LoginPage.LogIn_Action("testuser_1", "Test@123");

        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

        Thread.sleep(10000);
        //HomePage.lnk_LogOut.click();

    }

    @After

    public void afterMethod() {

        driver.quit();

    }

}