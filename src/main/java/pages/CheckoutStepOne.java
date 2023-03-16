package pages;

import config.ConfigTests;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOne {

    /**
     * Экземпляр драйвера для браузера
     */
    private WebDriver driver;

    /**
     * Экземпляр конфига с параметрами для тестов
     */
    private ConfigTests config = ConfigFactory.create(ConfigTests.class, System.getenv());

    @FindBy(id = "first-name")
    private WebElement FirstNameField;

    @FindBy(id = "last-name")
    private WebElement LastNameField;

    @FindBy(id = "postal-code")
    private WebElement PostalCodeField;

    @FindBy(id = "continue")
    private WebElement ContinueButton;

    public CheckoutStepOne (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutStepOne inputFirstName(String firstName) {
        FirstNameField.sendKeys(firstName);
        return this;
    }
    public CheckoutStepOne inputLastName(String lastName) {
        LastNameField.sendKeys(lastName);
        return this;
    }
    public  CheckoutStepOne inputPostalCode(String postalCode) {
        PostalCodeField.sendKeys(postalCode);
        return this;
    }
    public CheckoutStepOne clickContinueButton() {
        ContinueButton.click();
        return this;
    }

}
