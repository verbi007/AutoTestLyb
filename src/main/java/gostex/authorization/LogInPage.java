package gostex.authorization;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenide;
import gostex.main.MainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage extends BaseSelenide {
    private SelenideElement loginField = $(By.xpath("//input[@name='USER_LOGIN']"));
    private SelenideElement passwordField = $(By.xpath("//input[@name='USER_PASSWORD']"));
    private SelenideElement logInBtn = $(By.xpath("//input[@type='submit']"));


    public MainPage logIn(String loginValue, String  passwordValue) throws InterruptedException {
        loginField.sendKeys(loginValue);
        passwordField.sendKeys(passwordValue);
        logInBtn.click();
        Thread.sleep(5000);
        return new MainPage();
    }
}
