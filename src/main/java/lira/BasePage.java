package lira;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public abstract class BasePage {

    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void init() throws IOException {
        setUp();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
