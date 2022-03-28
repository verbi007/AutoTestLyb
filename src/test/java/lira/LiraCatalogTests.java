package lira;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LiraCatalogTests {

    @BeforeClass
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("lira.properties"));
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1600";
        Selenide.open(System.getProperty("url"));
    }

    @Test
    public void catalogTest() {
        new MainPage()
                .clickCatalog()
//                .selectCheckbox("Фотогаллерея")
//                .selectAge(5, 10)
//                .selectFilter("По алфавиту")
//                .selectAlhabetItem("N")
//                .selectProduct("nastya");
                .selectActionBtn("Сказочный патруль", "compare")
                .selectPage(5)
                .selectProduct("Discovery");

    }

    @Test
    public void loginTest() {
        new MainPage()
                .clickLogin()
                .authentication(System.getProperty("username.lira"),System.getProperty("password.lira"));
    }
}
