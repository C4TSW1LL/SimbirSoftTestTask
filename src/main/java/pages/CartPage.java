package pages;

import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    /**
     * Экземпляр драйвера для браузера
     */
    private WebDriver driver;

    /**
     * Экземпляр конфига с параметрами для тестов
     */
    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    @FindBy(id = "checkout")
    private WebElement CheckOutButton;

    public CartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public CartPage clickChechoutButton() {
        CheckOutButton.click();
        return this;
    }
}
