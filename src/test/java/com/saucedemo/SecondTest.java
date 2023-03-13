package com.saucedemo;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SecondTest {

    public ChromeDriver driver;
    public ChromeOptions options;
    String currentText = "Epic sadface: Username and password do not match any user in this service";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ IDEA Community Edition 2022.3.2\\Code\\TestTask\\QAA\\driver\\chromedriver.exe");

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void SecondTestCase() {
        driver.findElement(By.id("user-name")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.id("login-button")).click();
        WebElement secondText = driver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
        System.out.println(secondText.getText());
        if (currentText.equals(secondText.getText())) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}

