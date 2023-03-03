package moodle;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Главная страница
 */
public class MainPage extends BasePage{
    private SelenideElement title = $("span.site-name");

    public MainPage checkText(String text) {
        title.shouldHave(Condition.text(text));
        return this;
    }
}
