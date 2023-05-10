package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static java.lang.String.valueOf;

public class NewReleaseProducts extends Utils {
    public void newReleaseProductComment() {
        String expected = "Your comment has been added";
        //title
        sendText(By.id("AddNewComment_CommentTitle"), "Write Title");
        //comment
        sendText(By.xpath("//textarea[@name='AddNewComment.CommentText']"), "Leave your Comment");
        //click on new comment
        clickOnElement(By.xpath("//*[text()='New comment']"));
        //print comments
        List<WebElement> comments = driver.findElements(By.xpath("//div[@class=\"comments\"]"));
        for (WebElement e : comments) {
            System.out.println(e.getText());
            Assert.assertEquals(e.getText(), expected);
        }
    }
}