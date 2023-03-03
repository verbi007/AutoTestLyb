package academy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.BaseSelenide;


import static com.codeborne.selenide.Selenide.$;

public class TestsPage extends BaseSelenide {

    private SelenideElement textareaField = $("#autocompletion-textarea");
    private SelenideElement responseAlert = $(".text");
    private SelenideElement enterBtn = $(".check-sql");

    public TestsPage inputRequest(String request) {
        textareaField.sendKeys(request);
        enterBtn.click();
        return this;
    }

    public void checkAlert() {
        responseAlert.shouldBe(Condition.text("Решение верно"));
    }
}
