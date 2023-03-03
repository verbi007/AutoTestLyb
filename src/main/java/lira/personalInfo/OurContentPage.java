package lira.personalInfo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lira.PersonalAreaPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OurContentPage extends PersonalAreaPage {
    /**
     * Закладка "Наш контент"
     */
    private SelenideElement fieldSearch = $("#content-head-field-search");
    private SelenideElement inputDropDown = $(".el-input__inner");
    private ElementsCollection selectDropDown = $$(".el-select-dropdown__item");
    private SelenideElement selectedDropDown = $(".el-select-dropdown__item selected");
    private SelenideElement createNewBtn = $(".account__content-create-btn");
    private SelenideElement checkboxSelectAll = $(".control__text");
    private ElementsCollection checkboxInput = $$(".control__input");
    private ElementsCollection productCard = $$(By.xpath("//div[@role='group']//*[contains(@class,'account__content-list-col_main')]"));
    private ElementsCollection productCards = $$(By.xpath("//div[@role='group']"));
    private SelenideElement dateProduct = $(".account__content-list-col_date");

    /**
     * Ввод в поле поиска
     * @param text - вводимое значение
     * @return - подстраница "Наш контент"
     */
    public OurContentPage inputSearchField(String text) {
        fieldSearch.val(text).shouldHave(Condition.value(text));
        return this;
    }

    /**
     * Выбрать из селекта
     * @param item - "По дате создания", "По алфавиту"
     * @return - подстраница "Наш контент"
     * */
    public OurContentPage selectFilter(String item) {
        inputDropDown.click();
        selectDropDown.findBy(Condition.attribute("innerText", item)).click();
        inputDropDown.click();
        inputDropDown.shouldHave(Condition.attribute("placeholder", item)).pressEscape();
        return this;
    }

    /**
     * Проверка работы поля поиск
     * @param text - вводимое значение
     * @param itemFilter - "По дате создания", "По алфавиту"
     * @return
     */
    public OurContentPage checkSearchField(String text, String itemFilter) {
        inputSearchField(text);
        selectFilter(itemFilter);
        return this;
    }

    public OurContentPage selectProductByNameAndByDate(String name, String date) throws InterruptedException {
        SelenideElement el = productCard.findBy(Condition.text(name))
                .parent().find(".account__content-list-col_date").shouldBe(Condition.text(date))
                .preceding(1).lastChild();
        SelenideElement dl = productCard.findBy(Condition.text(date));
        el.click();
        int r = 0;
        return this;
    }
}
