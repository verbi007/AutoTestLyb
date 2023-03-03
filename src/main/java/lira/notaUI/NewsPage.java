package lira.notaUI;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.BaseSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends BaseSelenide {
    private SelenideElement titleH1 = $(".title_h1");
    private SelenideElement newsUrl = $(By.xpath("//body"));


    public NewsPage checkTitleH1() {
        titleH1.shouldHave(Condition.text("В ожидании «Холодное сердце 3» - Олаф пародирует фильмы Disney"));
        return this;
    }

    public NewsPage checkUrl() {
        newsUrl.shouldBe(Condition.attribute("baseURI", "https://lira.notamedia.ru/news/detail/VoghidaniiHolodnoeserdce3-OlafparodiruetfilymyDisney/"));
        return this;
    }
}
