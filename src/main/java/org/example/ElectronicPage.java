package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
public class ElectronicPage extends Utils {
    public void addToCart() {
        String expectedResult = "Item has been added...";
        clickOnElement(By.xpath("(//a[@title='Show products in category Camera & photo'])[1]"));
        //click on add to cart butoon
        clickOnElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]"));
        //click on shopping cart
        clickOnElement(By.className("cart-label"));
        // get name of product added in cart to match with selected product
        String name1 = getTextFromElement(By.className("product-name"));
        //Print message
        System.out.println(name1);
        //click on cart
        driver.findElement(By.className("cart-label")).click();
        //catch name of product added in cart
        String name = driver.findElement(By.className("product-name")).getText();
        //print name, if both are same then added product same in the cart
        System.out.println(name);
        Assert.assertEquals(expectedResult, name, "Item added");
    }
}