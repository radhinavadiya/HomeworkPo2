package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.function.Function;

public class FacebookConnect extends Utils {

    public void facebookClick() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //  Assert.assertEquals(driver.getCurrentUrl(), "Facebook.com");
        clickOnElement(By.xpath("(//*[text()='Allow all cookies'])[2]"));
        if (driver.findElement(By.xpath("(//input[@dir='ltr'])[17]")).isDisplayed()) {
            System.out.println("Email placeholder is there");
        }
        if (driver.findElement(By.xpath("(//input[@dir='ltr'])[18]")).isEnabled()) {
            System.out.println("Password placeholder is there");
        }
        if (driver.findElement(By.xpath("//div[@class='x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt']")).isEnabled()) {
            System.out.println("Log in button is there");
        }
        driver.close();
        getTextFromElement(By.xpath("//*[text()='Welcome to our store']"));

    }
}

