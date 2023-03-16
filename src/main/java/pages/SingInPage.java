package pages;

import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Работа со страницей входа в аккаунт
 */
public class SingInPage {

    /**
     * Экземпляр драйвера для браузера
     */
    private WebDriver driver;

    /**
     * Экземпляр конфига с параметрами для тестов
     */
    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    /**
     * Элемент поля имени пользователя на странице
     */
    @FindBy(id = "user-name")
    private WebElement FieldUserName;

    /**
     * Элемент поля пароля на странице
     */
    @FindBy(id = "password")
    private WebElement FieldPassword;

    /**
     * Элемент кпонки входа на странице
     */
    @FindBy(id = "login-button")
    private WebElement LoginButton;

    /**
     * Конструктор для страницы входа
     *
     * @param driver драйвер для управления браузером
     */
    public SingInPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SingInPage inputUserName(String userName) {
        FieldUserName.sendKeys(userName);
        return this;
    }

    public SingInPage inputPassword(String passWord) {
        FieldPassword.sendKeys(passWord);
        return this;
    }
    public SingInPage clickLoginButton() {
        LoginButton.click();
        return this;
    }
}
