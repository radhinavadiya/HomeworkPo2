package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationDetails extends Utils {
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _email = By.name("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");

    String expectedResult = " Registration  completed";

    public void EnterRegistrationDetails() {
        sendText(_firstName, "TestFirstName");
        // driver.findElement(By.id("FirstName")).sendKeys("TestFirstName");
        sendText(_lastName, "TestLastName");

//        Select day = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
//        day.selectByIndex(2);
//        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
//
//        month.selectByVisibleText("March");
//        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
//        year.selectByValue("1914");
        index(By.xpath("//select[@name='DateOfBirthDay']"),2);
        text(By.xpath("//select[@name='DateOfBirthMonth']"),"June");

        value(By.xpath("//select[@name='DateOfBirthYear']"), "1915");

        sendText(_email, "TestEmail@gmail.com");
        // driver.findElement(By.id("Password")).sendKeys("Test1234");
        sendText(_password, "Test1234");
        // driver.findElement(By.id("ConfirmPassword")).sendKeys("Test1234");
        sendText(_confirmPassword, "Test1234");
        clickOnElement(By.id("register-button"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String message = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        //print message
        System.out.println(message);
        //Assertion
        Assert.assertEquals(expectedResult, message, "Registered successful");


    }
}
