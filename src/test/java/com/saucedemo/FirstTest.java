package com.saucedemo;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class FirstTest extends TestSetUp {
    public ChromeDriver driver;
    public ChromeOptions options;
    String currentUrl = "https://www.saucedemo.com/checkout-complete.html";
    //String currentText = "Thank you for your order!";
    String currentText = "THANK YOU FOR YOUR ORDER";
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\makar\\OneDrive\\Рабочий стол\\QAA\\driver\\chromedriver.exe");

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void FirstTestCase() {

        driver.findElement(By.xpath("//*[contains(@id, 'add-to-cart')]")).click();

        driver.findElement(By.cssSelector(("a[class=\"shopping_cart_link\"]"))).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("test");
        driver.findElement(By.id("last-name")).sendKeys("test");
        driver.findElement(By.id(("postal-code"))).sendKeys("test");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        String secondUrl = driver.getCurrentUrl();
        if (currentUrl.equals(secondUrl)) {
            System.out.println("Its works");
        } else {
            System.out.println("Doesnt works");
        }

        WebElement secondText = driver.findElement(By.cssSelector("h2[class=\"complete-header\"]"));
        System.out.println(secondText.getText());
        if (currentText.equals(secondText.getText())) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }


    }
}