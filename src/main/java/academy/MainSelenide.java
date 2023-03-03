package academy;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenide;

import static com.codeborne.selenide.Selenide.$;

public class MainSelenide extends BaseSelenide {

    private SelenideElement loginBtn = $(".link__signin");

    public LoginSelenide clickLoginBtn() {
        loginBtn.click();
        return new LoginSelenide();
    }



}
