package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationDetails extends Utils {
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _email = By.name("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");

    String expectedResult =" Registration  completed";
    public void EnterRegistrationDetails(){
        sendText(_firstName,"TestFirstName");
       // driver.findElement(By.id("FirstName")).sendKeys("TestFirstName");
        sendText(_lastName,"TestLastName");
       //driver.findElement(By.id("LastName")).sendKeys("TestLastName");
       // driver.findElement(By.name("Email")).sendKeys("TestEmail@gmail.com");
        sendText(_email,"TestEmail@gmail.com");
       // driver.findElement(By.id("Password")).sendKeys("Test1234");
        sendText(_password,"Test1234");
       // driver.findElement(By.id("ConfirmPassword")).sendKeys("Test1234");
        sendText(_confirmPassword,"Test1234");
        clickOnElement(By.id("register-button"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String message =getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        //print message
        System.out.println(message);
        //Assertion
        Assert.assertEquals(expectedResult, message, "Registered successful");

    }
}
