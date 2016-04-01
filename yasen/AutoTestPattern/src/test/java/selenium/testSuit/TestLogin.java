package selenium.testSuit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import selenium.pageObjectModel.BasePageObjects;

/**
 * Created by Yassen on 3/13/2016.
 */
public class TestLogin extends BasePageObjects{

    WebDriver driver = null;

    public TestLogin(){};



    public static void main(String[] args) {

    TestLogin testLogin = new TestLogin();
        testLogin.loginTo("Yasen","123456");

    }

}
