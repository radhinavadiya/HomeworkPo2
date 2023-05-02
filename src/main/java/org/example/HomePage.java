package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends Utils {
    By _registerButton = By.className("ico-register");
    By _communityVoteButton = By.id("pollanswers-2");
    By _productButton = By.xpath("(//a[@href='/build-your-own-computer'])[2]");
    By _addToCartButton = By.xpath("(//a[@title='Show products in category Electronics'])[1]");
    //click on electronics
    By _electronicClick = By.xpath("(//a[@title='Show products in category Electronics'])[1]");

    By _vertualcardclick = By.xpath("(//button[@type=\"button\"])[11]");


    public void clickOnRegisterButton() {

        clickOnElement(_registerButton);
    }

    public void clickonCommunityVote() {
        clickOnElement(_communityVoteButton);
        String expectedResult = "Only registered user can vote";
        //select vote
        //clickOnElement(By.id("pollanswers-2"));
        //click on button
        clickOnElement(By.xpath("//button[@id='vote-poll-1']"));
        //stop for while
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='poll-vote-error']"))).getText();
        //display text
        System.out.println(msg);
        //Assertion
        Assert.assertEquals(msg, expectedResult, "Registered user can vote");
    }

    public void clickOnBuldComputer() {
        clickOnElement(_productButton);
    }

    public void electronicClick() {
        clickOnElement(_electronicClick);
    }

    public void clickOnAddToCompareList() {
        //virtual card selection
        clickOnElement(_vertualcardclick);

        clickOnElement(By.xpath("(//button[@class='button-2 add-to-compare-list-button'])[4]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //click on product comparison list
        clickOnElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a"));
    }

    public void clickOnVoteforUser() {
        String expectedresult = " Vote has been sent";

        //click on vote
        clickOnElement(By.id("pollanswers-4"));
        //click on button
        clickOnElement(By.xpath("(//button[@type='button'])[13]"));
        //get message
        String msg = getTextFromElement(By.xpath("//span[@class='poll-total-votes']"));
        Assert.assertEquals(msg, expectedresult, "vote sent");
    }
}
