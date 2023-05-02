package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CompareList extends Utils {
    public void clickOnCart() {
        String expectedResult = "Item has been added..";
        // get name of product added in cart to match with selected product
        String name1 = getTextFromElement(By.className("product-name"));
        //Print message
        System.out.println(name1);
        //catch name of product added in cart
        String name = driver.findElement(By.className("product-name")).getText();
        //print name, if both are same then added product same in the cart
        System.out.println(name);
        Assert.assertEquals(expectedResult, name, "Item added");
    }
}
