package org.example;

import org.apache.commons.io.FileUtils;
import org.example.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.io.FileHandler;

import static org.example.BasePage.driver;

public class TestBase {

    DriverManager driverManager = new DriverManager();//object creation

    @AfterMethod
    public void tearDown() {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            try {
//                TakesScreenshot screenshot = (TakesScreenshot) driver;
//                File source = screenshot.getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(source, new File("src/main/java/org/example/Screenshots" + result.getName() + ".png"));
//
//            } catch (Exception e) {
//                System.out.println("error" + e.getMessage());
//            }
//        }
        driverManager.closeBrowser();
    }

    @BeforeMethod
    public void setUp() {
        //open browser
        driverManager.openBrowser();
        // driver.get("https://demo.nopcommerce.com/");
    }
}