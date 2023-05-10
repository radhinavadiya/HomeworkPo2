package org.example;

import org.openqa.selenium.By;

public class BillingOfBuildComputer extends Utils {
    public void billingProcess() {
//enter first name
        sendText(By.xpath("(//input[@type='text'])[2]"), "Test");
        sendText(By.xpath("(//input[@type='text'])[3]"), "testing");
        sendText(By.xpath("(//input[@type='email'])[1]"), "test@gmail.com");
        //select address an all mandatory details
        index(By.xpath("//select[@data-trigger='country-select']"), 6);
        sendText(By.xpath("(//input[@type='text'])[5]"), "London");
        sendText(By.xpath("(//input[@type='text'])[6]"), "Newburrypark");
        sendText(By.xpath("(//input[@type='text'])[7]"), "Ilford");
        sendText(By.xpath("(//input[@type='text'])[8]"), "789Y79");
        sendText(By.xpath("(//input[@type='tel'])"), "5676543256");
        clickOnElement(By.xpath("(//*[text()='Continue'])[1]"));
    }
}
