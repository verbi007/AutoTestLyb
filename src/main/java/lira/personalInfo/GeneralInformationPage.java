package lira.personalInfo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lira.PersonalAreaPage;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GeneralInformationPage extends PersonalAreaPage {

    /**
     * Закладка "Общая информация"
     */
    private SelenideElement fieldNameCompany = $("#info-field-name");

    private SelenideElement typeOfBusiness = $(".el-input__inner");
    private ElementsCollection selectTypeOfBusiness = $$(".el-select-dropdown__item");
    private SelenideElement typeOfBisnessText = $(".el-select-dropdown__item.selected span");

    private SelenideElement descriptionCompany = $("#info-field-desc");
    private SelenideElement fieldBank = $("#info-field-bank");
    private SelenideElement fieldAccount = $("#info-field-account");
    private SelenideElement fieldInn = $("#info-field-inn");
    private SelenideElement fieldKpp = $("#info-field-kpp");
    private SelenideElement fieldBik = $("#info-field-bik");
    private SelenideElement fieldOkpo = $("#info-field-okpo");
    private SelenideElement fieldKved = $("#info-field-kved");
    private SelenideElement fieldCorporateAcc = $("#info-field-corporateAccount");

    private SelenideElement fieldUrl = $("#info-field-url");
    private SelenideElement fieldHttp = $(".v-field__url-hint");
    private SelenideElement fileLogo = $(By.xpath("//input[@type='file']"));
    private SelenideElement fileUploadAction = $(".el-upload-list__item-actions");
    private SelenideElement fieldPassword = $("#info-field-password");
    private SelenideElement saveBtn = $(".mr-4");
    private SelenideElement cancelBtn = $(".btn_white");
    /**
     * Вввод в поле "Название организации"
     * @param nameCompany - название организации
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputFieldNameCompany(String nameCompany) {
        fieldNameCompany.val(nameCompany).shouldHave(Condition.value(nameCompany));
        return this;
    }

    /**
     * Ввод в поле "Тип бизнеса"
     * @param typeBusiness - тип бизнеса ИП или Организация
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputFieldTypeOfBusiness(String typeBusiness) {
        typeOfBusiness.click();
        selectTypeOfBusiness.findBy(Condition.text(typeBusiness)).click();
        typeOfBisnessText.shouldHave(Condition.text(typeBusiness));
        return this;
    }

    /**
     * Ввод в поле "Описание компании"
     * @param description - текст описания
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputDescription (String description) {
        descriptionCompany.val(description).shouldHave(Condition.text(description));
        return this;
    }

    /**
     * Ввод в поле "Банк"
     * @param bankInfo - банк
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputBankInfo(String bankInfo) {
        fieldBank.val(bankInfo).shouldHave(Condition.text(bankInfo));
        return this;
    }

    /**
     * Ввод в поле "Расчетный счет"
     * @param account - расчетный счет
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputAccount(String account) {
        fieldAccount.val(account).shouldHave(Condition.text(account));
        fieldAccount.shouldHave(Condition.attribute("maxlength", "20"));
        return this;
    }

    /**
     * Ввод в поле "ИНН"
     * @param inn - ИНН
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputInn(String inn) {
        fieldInn.val(inn).shouldHave(Condition.text(inn));
        fieldInn.shouldHave(Condition.attribute("maxlength", "10"));
        return this;
    }

    /**
     * Ввод в поле "КПП"
     * @param kpp - КПП
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputKpp(String kpp) {
        fieldKpp.val(kpp).shouldHave(Condition.text(kpp));
        fieldKpp.shouldHave(Condition.attribute("maxlength", "10"));
        return this;
    }

    /**
     * Ввод в поле "БИК банка"
     * @param bik - БИК
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputBikBank(String bik) {
        fieldBik.val(bik).shouldHave(Condition.text(bik));
        fieldBik.shouldHave(Condition.attribute("maxlength", "9"));
        return this;
    }

    /**
     * Ввод в поле "ОКПО"
     * @param okpo - ОКПО
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputOkpo(String okpo) {
        fieldOkpo.val(okpo).shouldHave(Condition.text(okpo));
        fieldOkpo.shouldHave(Condition.attribute("maxlength", "8"));
        return this;
    }

    /**
     * Ввод в поле "ОКОНХ/ОКВЭД"
     * @param kved - ОКВЭД
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputKved(String kved) {
        fieldKved.val(kved).shouldHave(Condition.text(kved));
        fieldKved.shouldHave(Condition.attribute("maxlength", "5"));
        return this;
    }

    /**
     * Ввод в поле "Кор. счет"
     * @param corAcc - корпоративный счет
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputCorporateAccount(String corAcc) {
        fieldCorporateAcc.val(corAcc).shouldHave(Condition.text(corAcc));
        fieldCorporateAcc.shouldHave(Condition.attribute("maxlength", "20"));
        return this;
    }

    /**
     * Ввод в поле "Сайт компании"
     * @param url - адрес сайта
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputUrl(String url) {
        url = url.trim();
        fieldUrl.val(url);
        if (url.matches("^https:\\/\\/[\\w\\W\\d]*$")) {
            fieldHttp.shouldHave(Condition.text("https://"));
            fieldUrl.shouldHave(Condition.value(url.replaceAll("^https:\\/\\/", "")));
        } else {
            fieldHttp.shouldHave(Condition.text("http://"));
            fieldUrl.shouldHave(Condition.value(url.replaceAll("^http:\\/\\/", "")));
        }
        return this;
    }

    /**
     * Загрузка логотипа компании
     * @param logoFile - файл логотипа
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage loadingLogoFile(File logoFile) {
        fileLogo.uploadFile(logoFile);
        fileUploadAction.shouldBe();
        return this;
    }

    /**
     * Ввод в поле "Пароль"
     * @param password - пароль
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage inputPassword(String password) {
        fieldPassword.val(password).shouldHave(Condition.value(password));
        fieldPassword.shouldBe(Condition.attribute("type", "password"));
        return this;
    }

    /**
     * Кликнуть по кнопке "Сохранить"
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage clickSaveBtn() {
        saveBtn.click();
        saveBtn.shouldHave(Condition.attribute("disabled", "true"));
        return this;
    }

    /**
     * Кликнуть по кнопке "Отмена"
     * @return - подстраница "Общая информация"
     */
    public GeneralInformationPage clickCancelBtn() {
        cancelBtn.click();
        cancelBtn.shouldBe(Condition.disappear);
        return this;
    }

}
