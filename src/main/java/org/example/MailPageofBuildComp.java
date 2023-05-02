package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class MailPageofBuildComp extends Utils {
    private By _friendEmail = By.id("FriendEmail");
    private By _yourMail = By.className("your-email");

    public void clickOnMail() {
        String expectedmsg = "Product hase been referred";
        //click on friend mail
        sendText(_friendEmail, "abc@gmail.com");
        //type your mail
        // sendText(_yourMail,"TestEmail@gmail.com");
        //click on send mail
        clickOnElement(By.name("send-email"));        //get msg
        String msg1 = getTextFromElement(By.className("result"));
        System.out.println(msg1);//print message
        Assert.assertEquals(msg1, expectedmsg, "Product has been referred");
    }
}
