package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Function;

public class FacebookConnect extends Utils {

    public void facebookClick() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        Assert.assertNotEquals(driver.getCurrentUrl(), "Facebook.com");
        clickOnElement(By.xpath("(//*[text()='Allow all cookies'])[2]"));
        //check for email function
        if (isEnabled(By.xpath("(//input[@dir='ltr'])[17]"))) {
            System.out.println("Email placeholder is there");

        }
        if (isEnabled(By.xpath("(//input[@dir='ltr'])[18]"))) {
            System.out.println("Password placeholder is there");
        }
        if (isEnabled(By.xpath("//div[@class='x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt']"))) {
            System.out.println("Log in button is there");
        }
        driver.close();
        for (String mainwindow : driver.getWindowHandles()) {
            driver.switchTo().window(mainwindow);

            String actualmsg = getTextFromElement(By.xpath("//*[text()='Welcome to our store']"));
            Assert.assertEquals(actualmsg, "Wellcome to our store....");
        }
    }
}

