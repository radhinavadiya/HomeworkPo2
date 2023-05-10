package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class PaymentOfComputer extends Utils{
    public void payment(){
        String expected="Your order has been placed as a guest";
    //select credit card
    clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
    //continue
    clickOnElement(By.xpath("(//button[@name='save'])[2]"));
    //creditcard selection
    index(By.id("CreditCardType"), 1);
    //enter card details
    sendText(By.xpath("(//input[@style='width:165px;'])[1]"), "MASTERCARD");
    sendText(By.xpath("(//input[@style='width:165px;'])[2]"), "5583925995495332");
    index(By.xpath("(//select[@data-val=\"true\"])[2]"), 8);
    index(By.xpath("(//select[@data-val=\"true\"])[3]"), 3);
    sendText(By.xpath("(//input[@style='width:60px;'])"), "854");
    //click on continue
    clickOnElement(By.xpath("(//*[text()='Continue'])[5]"));
    clickOnElement(By.xpath("//*[text()='Confirm']"));
        String msg =getTextFromElement(By.xpath("//*[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(msg,expected);
    }

}
