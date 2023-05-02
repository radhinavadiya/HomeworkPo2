package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager extends Utils {//extends utils to user method from it
    public void closeBrowser() {

        driver.close();//to close browser
    }

    public void openBrowser() {
        driver = new ChromeDriver();//object creation
        driver.get("https://demo.nopcommerce.com/");//url
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }
}
