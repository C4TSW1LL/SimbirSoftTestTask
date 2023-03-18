package pages;

import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Работа со страницей корзины
 */
public class CartPage {

    /**
     * Экземпляр драйвера для браузера
     */
    private WebDriver driver;

    /**
     * Экземпляр конфига с параметрами для тестов
     */
    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    /**
     * Элемент кнопки начала оформления покупки
     */
    @FindBy(id = "checkout")
    private WebElement CheckOutButton;

    /**
     * Конструктор для страницы корзины
     *
     * @param driver драйвер для управления браузером
     */
    public CartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод нажания на кнопку оформления покупки
     *
     * @return текущая страница
     */
    public CartPage clickChechoutButton() {
        CheckOutButton.click();
        return this;
    }
}
