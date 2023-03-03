package lira.notaUI;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.BaseSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BaseSelenide {

    private SelenideElement logInButton = $("button.header__login-button");
    private SelenideElement mainUrl = $(By.xpath("//body"));
    private SelenideElement firstNews = $(".news-article__first-item_top");
    private SelenideElement subscribeNews = $(".header__action-button");
    private SelenideElement modalWindow = $("#modal");

    public AuthorizationPage clickLogInButton() {
        logInButton.click();
        return new AuthorizationPage();
    }

    public MainPage checkUrl() {
        mainUrl.shouldHave(Condition.attribute("baseURI", "https://lira.notamedia.ru/news/"));
        return this;
    }

    public NewsPage clickFirstNews() {
        firstNews.click();
        return new NewsPage();
    }

    public MainPage clickSubscribeNews() {
        subscribeNews.click();
        return this;
    }

}
