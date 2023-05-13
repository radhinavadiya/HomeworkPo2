package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import  java.util.Date;
//import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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

    }public boolean isEnabled(By by){
        driver.findElement(by).isEnabled();
        return true;
    }public static String currentTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
        return sdf.format(date);
    }public static void captureScreenshot( String fileName)
    {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File
                SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File destFile=new
                File("src\\test\\Screenshots\\"+fileName+""+currentTimeStamp()+".png");
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, destFile );
        } catch (IOException e) {
            e.printStackTrace();
        }
}}
