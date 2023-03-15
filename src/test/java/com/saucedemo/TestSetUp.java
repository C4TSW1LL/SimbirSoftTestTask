package com.saucedemo;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Класс настроек всех тестов
 */
public class TestSetUp {
    /**
     * Переменные с экземплярами драйвера и настроек браузера
     */
    protected ChromeDriver driver;
    public ChromeOptions options;

    /**
     * Общие настройки тестов перед выполнением
     */
    @Before
    public void setUp() {
        // Установка драйвера и пути к нему
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\makar\\OneDrive\\Рабочий стол\\QAA\\driver\\chromedriver.exe");

        // Создание экземпляра настройки браузера
        options = new ChromeOptions();

        // Установка фикса открытия страницы "data.." вместо указанного url
        options.addArguments("--remote-allow-origins=*");

        // Создание экземпляра драйвера с примененным фиксом
        driver = new ChromeDriver(options);

        // Открытие страницы по url
        driver.get("https://www.saucedemo.com/");

        // Открытие браузера на полный экран
        driver.manage().window().fullscreen();
    }

    /**
     * Общие настройки тестов перед выполнением
     */
    @After
    public void shutDown() {

        // Закрытие браузера
        driver.close();
    }
}
