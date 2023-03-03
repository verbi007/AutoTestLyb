package iFellow;


import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public abstract class BasePage {

    /**
     * Инициализация драйвера
     */
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public static void init() {
        setUp();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
