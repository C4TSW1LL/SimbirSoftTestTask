package com.saucedemo;


import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SecondTest extends TestSetUp {
    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    //String currentText = "Epic sadface: Username and password do not match any user in this service";



    @Test
    public void SecondTestCase() {
        driver.findElement(By.id("user-name")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.id("login-button")).click();
        WebElement secondText = driver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
        System.out.println(secondText.getText());
        if (config.currentTextFor2TC().equals(secondText.getText())) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}

