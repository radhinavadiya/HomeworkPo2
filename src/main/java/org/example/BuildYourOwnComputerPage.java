package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BuildYourOwnComputerPage extends Utils {
    String expectedResult = "Only Registered user can SendMail";
    ShoppingCart shoppingCart = new ShoppingCart();

    public void buildOwnComputer() {
        //click on send email
        clickOnElement(By.xpath("(//button[@type='button'])[4]"));
        sendText(By.className("friend-email"), "friends123@gmail.com");
        //type your mail
        sendText(By.className("your-email"), "TestEmail@gmail.com");
        // click on send email
        clickOnElement(By.name("send-email"));
        //catch message
        String s = getTextFromElement(By.xpath("//div[@class='result']"));
        //print msg
        System.out.println(s);
        Assert.assertEquals(expectedResult, s, "User can send Mail");
    }

    public void chekoutAsGuest() {
        //select fropm dropdown
        //clickOnElement(By.xpath("//select[@data-attr='1']"));
        index(By.xpath("//select[@data-attr='1']"), 1);
        //select ram
        index(By.xpath("//select[@data-attr='2']"), 3);
        //select 320
        clickOnElement(By.xpath("//*[text()='320 GB']"));
        //select vista premium
        clickOnElement(By.xpath("//*[text()='Vista Premium [+$60.00]']"));
        //checkin all check box
        clickOnElement(By.xpath("//input[@id='product_attribute_5_11']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //click on add to cart
        clickOnElement(By.id("add-to-cart-button-1"));
        //click on cart
        clickOnElement(By.xpath("//*[text()='shopping cart']"));
    }
}


