package lira.notaUI;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenide;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage extends BaseSelenide {
    private SelenideElement loginAndEmail = $("#content__form-login");
    private SelenideElement password = $("#content__form-password");
    private SelenideElement checkBoxFormSave = $("#formSave");
    private SelenideElement logInButton = $(".customButton");


    public MainPage logIn() {
        loginAndEmail.sendKeys(System.getProperty("login"));
        password.sendKeys(System.getProperty("password"));
        logInButton.click();
        return new MainPage();

    }


}
