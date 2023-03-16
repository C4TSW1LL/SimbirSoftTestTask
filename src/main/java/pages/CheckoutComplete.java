package pages;

import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {

    /**
     * Экземпляр драйвера для браузера
     */
    private WebDriver driver;

    /**
     * Экземпляр конфига с параметрами для тестов
     */
    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    @FindBy(css = "h2[class=\"complete-header\"]")
    private WebElement currentText;

    private WebDriver currentUrl;

    public CheckoutComplete(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutComplete urlComparison(String url) {
        currentUrl.getCurrentUrl().equals(url);
        return this;

    }
    public CheckoutComplete textComparsion(String text) {
        currentText.getText().assert;
        return this;
    }
}
