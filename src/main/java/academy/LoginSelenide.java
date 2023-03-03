package academy;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginSelenide extends BaseSelenide {

    private SelenideElement emailField = $(By.xpath("//input[@name='email']"));
    private SelenideElement passwordField = $(By.xpath("//input[@name='password']"));
    private SelenideElement loginBtn = $(By.xpath("//button[@type='submit']"));

    public FirstSelenide logIn(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        return new FirstSelenide();
    }
}
