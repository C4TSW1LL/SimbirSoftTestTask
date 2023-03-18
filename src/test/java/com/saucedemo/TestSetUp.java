package com.saucedemo;

import config.ConfigTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Класс настроек всех тестов
 */
public class TestSetUp {
    /**
     * Переменные с экземплярами драйвера и настроек браузера
     */
    protected WebDriver driver;
    public ChromeOptions options;

    /**
     * Экземпляр конфига с параметрами
     */
    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    /**
     * Общие настройки тестов перед выполнением
     */
    @Before
    public void setUp() {
        // Установка драйвера GoogleChrome
        WebDriverManager.chromedriver().setup();

        // Создание экземпляра настройки браузера
        options = new ChromeOptions();

        // Установка фикса открытия страницы "data.." вместо указанного url
        options.addArguments("--remote-allow-origins=*");

        // Создание экземпляра драйвера с примененным фиксом
        driver = new ChromeDriver(options);

        // Открытие браузера на полный экран
        driver.manage().window().maximize();

        // Открытие страницы по url
        driver.get(config.url());


    }

    /**
     * Общие настройки тестов после выполнения
     */
    @After
    public void shutDown() {

        // Закрытие браузера
        driver.close();
    }
}
