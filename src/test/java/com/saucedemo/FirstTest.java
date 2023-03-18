package com.saucedemo;
import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import pages.*;

/**
 * Основной класс с тестами Saucedemo
 */

public class FirstTest extends TestSetUp {

    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    @Test()
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
                .textComparsion("Thank you for your order!");
        //THANK YOU FOR YOUR ORDER
        //Thank you for your order!
    }
}