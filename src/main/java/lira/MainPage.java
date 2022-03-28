package lira;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage{
    private SelenideElement catalogBtn = $(By.xpath("//a[@href='/catalog/']"));
    private SelenideElement loginBtn = $(By.xpath("//a[@href='/auth/']"));

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

}
