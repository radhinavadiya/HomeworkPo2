package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.sql.Timestamp;

public class Utils extends BasePage {
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static void sendText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static long timeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();

 }
    public void logIn() {
        clickOnElement(By.className("ico-login"));
        //enter email
        sendText(By.id("Email"), "TestEmail@gmail.com");
        //add passwordd
        sendText(By.id("Password"), "Test1234");
        //click on login button
        clickOnElement(By.xpath("//button[@class=\"button-1 login-button\"]"));
    }

    public void index(By by, int num) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(num);
    }

    public void text(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void value(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }
}
