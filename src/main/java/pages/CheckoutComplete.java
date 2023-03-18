package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Работа со страницей подтвержденного заказа
 */
public class CheckoutComplete {

    /**
     * Экземпляр драйвера для браузера
     */
    private WebDriver driver;

    /**
     * Элемент текста об успешном создании заказа
     */
    @FindBy(css = "h2[class=\"complete-header\"]")
    private WebElement currentText;

    private WebDriver currentUrl;

    /**
     * Конструктор для страницы подтвержденного заказа
     *
     * @param driver драйвер для управления браузером
     */
    public CheckoutComplete(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод сравнения url
     *
     * @param url эталонный url
     * @return
     */
    public CheckoutComplete urlCompression(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return this;
    }

    /**
     * Метод стравнения текста
     *
     * @param text эталонный текст
     * @return
     */
    public void textCompression(String text) {
        Assert.assertEquals(text, currentText.getText());
    }
}
