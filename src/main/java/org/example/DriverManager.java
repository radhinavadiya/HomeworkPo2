package org.example;

import org.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.time.Duration;
import java.util.Properties;


public class DriverManager extends Utils {//extends utils to user method from it
    LoadProp loadProp = new LoadProp();
    public void closeBrowser() {

        driver.close();//to close browser
    }

    public void openBrowser() {
//       // driver = new ChromeDriver();//object creation
        driver = new HtmlUnitDriver(BrowserVersion.FIREFOX);
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("--headless");
//       driver=new EdgeDriver(options);

        driver.get(loadProp.getProperty("url"));
        //  driver.get("https://demo.nopcommerce.com/");//url
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }
}
