package lira;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private SelenideElement loginInput = $(By.xpath("//input[@name='USER_LOGIN']"));
    private SelenideElement passwordInput = $(By.xpath("//input[@name='USER_PASSWORD']"));
    private SelenideElement loginBtn = $(".auth__button");

    private SelenideElement forgotPassLink = $(By.xpath("//a[@href='/auth/foget.php']"));
    private SelenideElement registerLink = $(By.xpath("//a[@href='/auth/registration.php']"));


    public MainPage authentication(String login, String password) {
        loginInput.val(login);
        passwordInput.val(password);
        loginBtn.click();
        return new MainPage();
    }


}

