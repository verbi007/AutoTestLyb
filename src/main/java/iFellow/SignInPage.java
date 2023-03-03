package iFellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage extends BasePage{
    private SelenideElement usernameField = $x("//input[@id='login-form-username']");
    private SelenideElement passwordField = $x("//input[@id='login-form-password']");
    private SelenideElement logInBtn = $x("//input[@id='login']");


    /**
     * Авторизация
     * @param username - имя пользователя
     * @param password - пароль
     * @return - MainPage
     */
    public MainPage logIn(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        clickLogInBtn();
        return new MainPage();
    }


    /**
     * Нажать на кнопку войти
     */
    public void clickLogInBtn() {
        logInBtn.click();
    }
}
