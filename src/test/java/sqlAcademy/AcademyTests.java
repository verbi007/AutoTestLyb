package sqlAcademy;

import academy.MainSelenide;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AcademyTests {

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("sql.properties"));
        Configuration.browserSize = "2560x1440";
        Selenide.open(System.getProperty("url.academy"));
    }

    @Test
    public void requestTest() {
        new MainSelenide()
                .clickLoginBtn()
                .logIn(System.getProperty("login"), System.getProperty("password"))
                .clickOnlineTrainer()
                .clickLesson("1")
                .inputRequest("select name from Passenger")
                .checkAlert();
    }
}
