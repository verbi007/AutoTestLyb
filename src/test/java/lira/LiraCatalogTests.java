package lira;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class LiraCatalogTests {

    @BeforeClass
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("lira.properties"));
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1600";
        Selenide.open(System.getProperty("url.main"));
    }

    @Test
    public void catalogTest() {
        new MainPage()
                .clickCatalog()
                .selectCheckbox("Фотогаллерея")
                .selectAge(5, 10)
                .selectFilter("По алфавиту")
                .selectAlhabetItem("N")
                .selectProduct("nastya");
//                .selectActionBtn("Сказочный патруль", "compare")
//                .selectPage(5)
//                .selectProduct("Discovery");

    }

    @Test
    @DisplayName("Позитивный тест авторизации")
    public void loginTest() {
        new MainPage()
                .clickLogin()
                .authentication(System.getProperty("username.lira"),System.getProperty("password.lira"))
                .checkUrl();
    }


    @Test
    @DisplayName("Позитивный тест личного кабинета вкладки \"Общая информация\"")
    public void personalAreaTest() {
        System.out.println(new File(getClass().getClassLoader().getResource("devil.jpg").getPath()));
        new MainPage()
                .clickLogin()
                .authentication(System.getProperty("username.lira"), System.getProperty("password.lira"))
                .goToPersonalArea()
                .selectGeneralInfoPage()
                .inputFieldNameCompany("Jmb")
                .inputFieldTypeOfBusiness("ИП")
                .inputDescription("Good company!")
                .inputBankInfo("tinkoff")
                .inputAccount("12345678912345678912")
                .inputInn("1234567891")
                .inputKpp("1234567891")
                .inputBikBank("123456789")
                .inputOkpo("12345678")
                .inputKved("12345")
                .inputCorporateAccount("12345678912345678912")
                .inputUrl("https://lira.notamedia.ru/")
                .loadingLogoFile(new File(getClass().getClassLoader().getResource("devil.jpg").getPath()))
                .inputPassword("test123456")
                .clickSaveBtn();
    }

    @Test
    @DisplayName("Позитивный тест личного кабинета вкладки \"Общая информация\"")
    public void personalAreaTest_OurContent() throws InterruptedException {
        System.out.println(new File(getClass().getClassLoader().getResource("devil.jpg").getPath()));
        new MainPage()
                .clickLogin()
                .authentication(System.getProperty("username.lira"), System.getProperty("password.lira"))
                .goToPersonalArea()
                .selectOurContentPage()
                .checkSearchField("test", "По алфавиту")
                .selectProductByNameAndByDate("test", "31.03.2022");
    }
}
