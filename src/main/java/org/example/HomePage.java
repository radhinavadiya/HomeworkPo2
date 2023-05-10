package org.example;


import antlr.ASTNULLType;
import antlr.CommonToken;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.reporters.EmailableReporter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
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

    public void printOutProductNames() {
        List<WebElement> productList = driver.findElements(By.cssSelector("div.product-grid h2"));
        for (WebElement e : productList) {
            System.out.println(e.getText());
        }
    }

    public void currencySelect() {
        // store all products with the dollar
        index(By.name("customerCurrency"), 0);
        List<WebElement> currency = driver.findElements(By.cssSelector("span.price"));
        System.out.println("Products when currency chosen as US Dollar: ");
        String dollar = "$";
        for (WebElement e : currency) {
            if (e.getText().startsWith(dollar)) {
                // clickOnElement(By.id("customerCurrency"));

            }
            System.out.println(e.getText());
            System.out.println(" price is in $");
        }


        //select currency from the currency selector
        index(By.name("customerCurrency"), 1);
        // store all products with the dollar currency
        List<WebElement> currency1 = driver.findElements(By.cssSelector("span.price"));
        // fetch all products with the same currency using the loop
        System.out.println("Products when currency chosen as Euro: ");
        //String euro = "€";
        int i = 0;

        for (WebElement e1 : currency1)
            if (e1.getText().startsWith("€"))
                System.out.println(" price in euro");
    }

    public void printelert() {
        String expectedMsg = "Write in search Placeholder";
        clickOnElement(By.xpath("//button[@type='submit']"));
        String alert = driver.switchTo().alert().getText();
        //System.out.println(alert);
        driver.switchTo().alert().accept();
        Assert.assertEquals(alert, expectedMsg, "Typesomething to search");
    }

    public void voteWithoutSelecting() {
        //click on vote
        clickOnElement(By.id("vote-poll-1"));
        String alert = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(alert, "Only registered user can vote");
    }

    public void connectFacebook() {
        //click on facebook
        clickOnElement(By.xpath("//*[text()='Facebook']"));

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
        if (driver.findElement(By.xpath("(//input[@dir='ltr'])[18]")).isEnabled()){
            System.out.println("Password placeholder is there");
        }
        if (driver.findElement(By.xpath("//div[@class='x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt']")).isEnabled()){
            System.out.println("Log in button is there");
        }driver.close();
        getTextFromElement(By.xpath("//*[text()='Welcome to our store']"));

    }

    public void newRelease() {
        //click on new release
        clickOnElement(By.partialLinkText("nopCommerce new release!"));
    }


    public void clickOnSearchButton(String searchText) {

        sendText(By.xpath("//input[contains(@type,'text')]"), searchText);

        clickOnElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));


        List<WebElement> collection_product_links =
                driver.findElements(By.cssSelector("div.product-grid h2"));

        //Validate if Search result is displayed corresponding
        //to the string which was searched
        for (int i = 0; i < collection_product_links.size(); i++) {
            String temp = collection_product_links.get(i).getText();

            if ((temp.toLowerCase().contains(searchText.toLowerCase()))) {
                Assert.assertTrue(true, searchText + " is displayed on product title Product Title: " + temp);
            } else {
                Assert.assertTrue(false, searchText + " is not displayed on product title Product Title: " + temp);

            }

        }
    }
}
