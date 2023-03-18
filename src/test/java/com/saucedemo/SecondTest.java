package com.saucedemo;


import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import pages.SingInPage;

/**
 * Основной класс с тестами Saucedemo
 */
public class SecondTest extends TestSetUp {

    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    @Test
    public void SecondTestCase() {
        new SingInPage(driver)
                .inputUserName("test")
                .inputPassword("test")
                .clickLoginButton()
                .textComparsion("Epic sadface: Username and password do not match any user in this service");
    }
}

