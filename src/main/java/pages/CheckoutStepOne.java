package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Работа с первой страницей оформления заказа
 */
public class CheckoutStepOne {

    /**
     * Экземпляр драйвера для браузера
     */
    private WebDriver driver;

    /**
     * Элемент имени на странице оформления заказа
     */
    @FindBy(id = "first-name")
    private WebElement FirstNameField;

    /**
     * Элемент фамилии на странице оформления заказа
     */
    @FindBy(id = "last-name")
    private WebElement LastNameField;

    /**
     * Элемент почтового индекса
     */
    @FindBy(id = "postal-code")
    private WebElement PostalCodeField;

    /**
     * Элемент кнопки продолжить
     */
    @FindBy(id = "continue")
    private WebElement ContinueButton;

    /**
     * Конструктор для первой страницы оформления заказа
     *
     * @param driver
     */
    public CheckoutStepOne(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод ввода имени
     *
     * @param firstName - имя закасчика
     * @return - текущая страница
     */
    public CheckoutStepOne inputFirstName(String firstName) {
        FirstNameField.sendKeys(firstName);
        return this;
    }

    /**
     * Метод ввода фамилии
     *
     * @param lastName - фамилия закасчика
     * @return - текущая страница
     */
    public CheckoutStepOne inputLastName(String lastName) {
        LastNameField.sendKeys(lastName);
        return this;
    }

    /**
     * Метод ввода почтового индекса
     *
     * @param postalCode - почтовый индекс закасчика
     * @return - текущая страница
     */
    public CheckoutStepOne inputPostalCode(String postalCode) {
        PostalCodeField.sendKeys(postalCode);
        return this;
    }

    /**
     * Метод нажания на кнопку продолжить оформление
     *
     * @return - текущая страница
     */
    public void clickContinueButton() {
        ContinueButton.click();
    }

}
