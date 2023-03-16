package pages;

import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    /**
     * Экземпляр драйвера для браузера
     */
    private WebDriver driver;

    /**
     * Экземпляр конфига с параметрами для тестов
     */
    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    /**
     * Элемент добавления в корзину первого товара на странице
     */
    @FindBy(xpath = "//button[contains(@id, 'add-to-cart')]")
    private WebElement FirstItemOnPage;

    /**
     * Элемент кнопки корзины
     */
    @FindBy(css = "a[class=\"shopping_cart_link\"]")
    private WebElement ShoppingCart;

    /**
     * Конструктор для страницы с товарами
     *
     * @param driver драйвер для управления браузером
     */
    public InventoryPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public InventoryPage chooseItem(int numberOfItem) {
        FirstItemOnPage.findElement(By.xpath("//button[contains(@id, 'add-to-cart')][" + numberOfItem +"]")).click();
        return this;
    }

    public InventoryPage clickCartButton() {
        ShoppingCart.click();
        return this;
    }

}
