package com.saucedemo;

import config.TestData;
import org.junit.Test;
import pages.*;

/**
 * Основной класс с тестами Saucedemo
 */

public class TestSaucedemo extends TestSetUp {

    @Test()
    public void VerificationOfASuccessfulPurchase() {
        new SingInPage(driver)
                .inputUserName(TestData.USERNAME)
                .inputPassword(TestData.PASSWORD)
                .clickLoginButton();

        new InventoryPage(driver)
                .chooseItem(1)
                .clickCartButton();

        new CartPage(driver)
                .clickCheckoutButton();

        new CheckoutStepOne(driver)
                .inputFirstName(TestData.TEST_STRING)
                .inputLastName(TestData.TEST_STRING)
                .inputPostalCode(TestData.TEST_STRING)
                .clickContinueButton();

        new CheckoutStepTwo(driver)
                .clickFinishButton();

        new CheckoutComplete(driver)
                .urlCompression(TestData.CHECKOUT_COMPLETE_URL)
                .textCompression(TestData.THANK_FOR_ORDER_MESSAGE);

    }

    @Test
    public void EnteringTheLoginOfANonExistentUser() {
        new SingInPage(driver)
                .inputUserName(TestData.TEST_STRING)
                .inputPassword(TestData.TEST_STRING)
                .clickLoginButton()
                .textCompression(TestData.LOGIN_ERROR_MESSAGE);
    }
}