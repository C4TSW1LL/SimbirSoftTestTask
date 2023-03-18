package pages;

import org.junit.Assert;
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
     * Элемент кпонки входа в аккаунт
     */
    @FindBy(id = "login-button")
    private WebElement LoginButton;

    /**
     * Текст в сообщении об ошибке
     */
    @FindBy(css = "h3[data-test=\"error\"]")
    private WebElement ErrorText;

    /**
     * Конструктор для страницы входа
     *
     * @param driver драйвер для управления браузером
     */
    public SingInPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод воода имени пользователя
     *
     * @param userName Имя пользователя
     * @return текущая страница
     */
    public SingInPage inputUserName(String userName) {
        FieldUserName.sendKeys(userName);
        return this;
    }

    /**
     * Метод ввода пароля
     *
     * @param passWord Пароль для входа
     * @return текущая страница
     */
    public SingInPage inputPassword(String passWord) {
        FieldPassword.sendKeys(passWord);
        return this;
    }

    /**
     * Метод нажатия кнопки входа в аккаунт
     *
     * @return текущая страница
     */
    public SingInPage clickLoginButton() {
        LoginButton.click();
        return this;
    }

    /**
     * Метод проверки текста ошибки на соответствие
     *
     * @param text Текст для проверки соответствия
     */
    public void textCompression(String text) {
        Assert.assertEquals(text, ErrorText.getText());
    }
}
