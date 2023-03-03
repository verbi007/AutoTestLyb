package lira;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage{
    private SelenideElement body = $(By.xpath("//body"));
    private SelenideElement catalogBtn = $(By.xpath("//a[@href='/catalog/']"));
    private SelenideElement loginBtn = $(By.xpath("//a[@href='/auth/']"));

    private SelenideElement profileBtn = $("#myDropBtn");
    private SelenideElement lkBtn = $(By.xpath("//a[@href='/lk/']"));
    private SelenideElement logOut = $(By.xpath("//a[@href='?logout=yes']"));

    /**
     * Переход на страницу "Каталог"
     * @return - страница каталога
     */
    public CatalogPage clickCatalog() {
        catalogBtn.click();
        return new CatalogPage();
    }

    /**
     * Переход на страницу "Авторизации и регистрации"
     * @return - страница авторизации
     */
    public LoginPage clickLogin() {
        loginBtn.click();
        return new LoginPage();
    }

    public MainPage checkUrl() {
        body.shouldHave(Condition.attribute("baseURI", "https://lira.notamedia.ru/news/"))
                .find(".title_h1").shouldHave(Condition.text("Новости"));
        return this;
    }

    public PersonalAreaPage goToPersonalArea() {
        profileBtn.click();
        lkBtn.click();
        return new PersonalAreaPage();
    }

}
