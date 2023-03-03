package lira;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage extends BasePage {
    /**
     * Левая сторона
     */
    // кнопка сброса фильтров
    private SelenideElement resetBtn = $(".expanded-reset");
    // список чекбоксов
    private ElementsCollection labelCheckboxs = $$(By.xpath("//span[@class='el-checkbox__label']/span"));
    //выбор диапазона возраста
    private SelenideElement ageFrom = $(By.xpath("//span[text()='от']/following::input"));
    private SelenideElement ageUpto = $(By.xpath("//span[text()='до']/following::input"));

    /**
     * Правая часть
     */
    private SelenideElement brandsBtn = $(By.xpath("//button[contains(text(),'Бренд')]"));
    private SelenideElement companyBtn = $(By.xpath("//button[contains(text(),'Компании')]"));
    private SelenideElement searchInput = $(".el-input__inner");
    private SelenideElement deleteSearchBtn = $(".el-input__clear");
    private SelenideElement alphaIndex = $(".alphabets-show-button");
    private ElementsCollection alphabet = $$(".alphabets__alphabet-item");
    private SelenideElement allBtn = $(".tags__tag");
    //селект "Сортировка" (сделан криво через input, работает только через клик)
    private SelenideElement selectSort = $(By.xpath("//input[@placeholder='Сортировка']"));
    private SelenideElement selectPop = $(By.xpath("//*[contains(text(),'По популярности')]"));
    private SelenideElement selectAlpha = $(By.xpath("//*[contains(text(),'По алфавиту')]"));

    /**
     * Карточки товаров
     */
    private ElementsCollection products = $$(".product");

    /**
     * Пагинация
     */
    private ElementsCollection pagination = $$(".number");
    private SelenideElement prevBtn = $(".btn-prev");
    private SelenideElement nextBtn = $(".btn-next");

    /**
     * Кнопка "Сброс" очищающая все фильтры
     *
     * @return - текущую страницу
     */
    public CatalogPage reset() {
        resetBtn.click();
        return this;
    }


    /**
     * Выбор любого чекбокса в фильтре в левой части по его названию
     *
     * @param title - название чекбокса
     * @return - текущую страницу
     */
    public CatalogPage selectCheckbox(String title) {
        if (labelCheckboxs.findBy(Condition.text(title)).isDisplayed()) {
            SelenideElement el = $$(By.xpath("//span[@class='el-checkbox__label']/span")).findBy(Condition.text(title));
            el.parent().parent().click();
        }
        return this;
    }

    /**
     * Выбор диапазона возраста от {from} и до {upTo}
     *
     * @param from - возраст от
     * @param upTo - возраст до
     * @return - текущую страницу
     */
    public CatalogPage selectAge(int from, int upTo) {
        ageFrom.sendKeys(String.valueOf(from));
        ageUpto.sendKeys(String.valueOf(upTo));
        return this;
    }


    /**
     * Выбор буквы в "Алфавитном указателе"
     *
     * @param text - выбор буквы в алфавите
     * @return - текущую страницу
     */
    public CatalogPage alphaItem(String text) {
        if (text.matches("[A-ZА-Я]")) {
            alphabet.findBy(Condition.text(text)).click();
        }
        return this;
    }

    /**
     * Разворачивание алфавита и выбор буквы
     *
     * @param text - выбор буквы в алфавите
     * @return - текущую страницу
     */
    public CatalogPage selectAlhabetItem(String text) {
        alphaIndex.click();
        alphaItem(text);
        return this;
    }

    /**
     * Выбор фильтра по популярности или по алфавиту
     *
     * @param item - выбор значения в селекте
     * @return - текущую страницу
     */
    public CatalogPage selectFilter(String item) {
        selectSort.click();
        if (item.trim().matches("По популярности")) {
            $(By.xpath(String.format("//*[contains(text(),'%s')]", item))).click();
        } else if (item.trim().matches("По алфавиту")) {
            $(By.xpath(String.format("//*[contains(text(),'%s')]", item))).click();
        }
        return this;
    }

    /**
     * Выбор карточки товара по названию продукта
     *
     * @param title - название товара
     * @return - текущую страницу
     */
    public CatalogPage selectProduct(String title) {
        selProd(title).click();
        return this;
    }

    public SelenideElement selProd(String title) {
        return products.findBy(Condition.attribute("innerText", title));
    }

    /**
     * Выбор пагинации
     *
     * @param page - номер страницы
     * @return - текущую страницу
     */
    public CatalogPage selectPage(int page) {
        pagination.findBy(Condition.text(String.valueOf(page))).click();
        return this;
    }

    /**
     * Выбор иконок сравнить и сердечко на карточке продукта
     *
     * @param title  - название карточки
     * @param action - выбор иконки
     */
    public CatalogPage selectActionBtn(String title, String action) {
        if (action.equals("compare")) selProd(title).$(".action-buttons__btn").click();
        else if (action.equals("like")) selProd(title).$(".action-buttons__btn+div").click();
        else return this;
        return this;
    }

}
