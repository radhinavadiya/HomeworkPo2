package org.example;

import org.openqa.selenium.By;

public class ShippingCopm extends Utils{
    public void shiiping(){
        //select next day delivery
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //continue
        clickOnElement(By.xpath("(//button[@onclick='ShippingMethod.save()'])"));
    }
}
