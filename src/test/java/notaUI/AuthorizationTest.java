package notaUI;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lira.notaUI.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthorizationTest {

    @BeforeClass
    public void setUp() throws IOException {
        ConfigInit.config("notaUI.properties", "url.notaUI");
    }

    @Test(testName = "Авторизация позитивный тест")
    public void authPositive() {
        new MainPage()
                .clickLogInButton()
                .logIn()
                .checkUrl();
    }
}
