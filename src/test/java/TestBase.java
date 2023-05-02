

import org.example.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase {

    DriverManager driverManager = new DriverManager();//object creation

    @AfterMethod
    public void tearDown() {//close broeser
        driverManager.closeBrowser();
    }

    @BeforeMethod
    public void setUp() {//oen browser
        driverManager.openBrowser();
        // driver.get("https://demo.nopcommerce.com/");
    }


}