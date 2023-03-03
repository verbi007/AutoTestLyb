package moodle;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Старница авторизации
 */
public class LoginPage extends BasePage {
    private SelenideElement username = $(By.id("username"));
    private SelenideElement password = $(By.id("password"));
    private SelenideElement loginBtn = $(By.id("loginbtn"));
    private SelenideElement checkboxRemeber = $(By.id("rememberusername"));

    public LoginPage(String url) {
        Selenide.open(url);
    }
    public MainPage logIn(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        checkboxRemeber.click();
        clickLoginBtn();
        return new MainPage();
    }



    public void clickLoginBtn() {
        loginBtn.click();
    }
}