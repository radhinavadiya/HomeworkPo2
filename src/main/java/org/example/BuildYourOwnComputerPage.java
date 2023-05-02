package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class BuildYourOwnComputerPage extends Utils {
    String expectedResult = "Only Registered user can SendMail";
    public void buildOwnComputer() {
        //click on send email
        clickOnElement(By.xpath("(//button[@type='button'])[4]"));
        sendText(By.className("friend-email"), "friends123@gmail.com");
        // click on send email
        clickOnElement(By.name("send-email"));
        //catch message
        String s = getTextFromElement(By.xpath("//div[@class='result']"));
        //print msg
        System.out.println(s);
        Assert.assertEquals(expectedResult, s, "User can send Mail");
    }
}