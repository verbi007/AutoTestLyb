package lira;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import lira.personalInfo.BrandsPage;
import lira.personalInfo.ContactsPage;
import lira.personalInfo.GeneralInformationPage;
import lira.personalInfo.OurContentPage;

import static com.codeborne.selenide.Selenide.$$;

public class PersonalAreaPage extends BasePage{
    private ElementsCollection linkBar = $$(".tabs__trigger");

    private GeneralInformationPage generalInformationPage;
    private OurContentPage ourContentPage;
    private BrandsPage brandsPage;
    private ContactsPage contactsPage;

    /**
     * Переход в подразделы "Личного кабинета"
     *
     */
    public GeneralInformationPage selectGeneralInfoPage() {
        linkBar.findBy(Condition.text("Общая информация")).click();
        return generalInformationPage = new GeneralInformationPage();
    }

    public OurContentPage selectOurContentPage() {
        linkBar.findBy(Condition.text("Наш контент")).click();
        return ourContentPage = new OurContentPage();
    }

    public BrandsPage selectBrandsPage() {
        linkBar.findBy(Condition.text("Бренды")).click();
        return brandsPage = new BrandsPage();
    }

    public ContactsPage selectContactsPage() {
        linkBar.findBy(Condition.text("Контакты")).click();
        return contactsPage = new ContactsPage();
    }
}
