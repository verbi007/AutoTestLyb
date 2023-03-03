package academySelenium;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement logInBtn;

    @FindBy(xpath = "//a[@href='/ru/trainer']")
    private WebElement onlineTrainer;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage logIn(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        logInBtn.click();
        return this;
    }

    public OnlineTrainerPage openOnlineTrainerPage() {
        onlineTrainer.click();
        return new OnlineTrainerPage();
    }


}
