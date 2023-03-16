package com.saucedemo;

import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

public class FirstTest extends TestSetUp {

    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    @Test
    public void FirstTestCase() {
        new SingInPage(driver)
                .inputUserName("standard_user")
                .inputPassword("secret_sauce")
                .clickLoginButton();

        new InventoryPage(driver)
                .chooseItem(1)
                .clickCartButton();

        new CartPage(driver)
                .clickChechoutButton();

        new CheckoutStepOne(driver)
                .inputFirstName("test")
                .inputLastName("test")
                .inputPostalCode("test")
                .clickContinueButton();

        new CheckoutStepTwo(driver)
                .clickFinishButton();

        new CheckoutComplete(driver)
                .urlComparison("https://www.saucedemo.com/checkout-complete.html")
                .textComparsion("THANK YOU FOR YOUR ORDER");

        String secondUrl = driver.getCurrentUrl();
        if (config.currentUrlFor1TC().equals(secondUrl)) {
            System.out.println("Its works");
        } else {
            System.out.println("Doesn't works");
        }

        WebElement secondText = driver.findElement(By.cssSelector("h2[class=\"complete-header\"]"));
        System.out.println(secondText.getText());
        if (config.currentTextFor1TC().equals(secondText.getText())) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

//button[contains(@id, 'add-to-cart')]
    }
}