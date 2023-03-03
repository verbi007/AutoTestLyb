package gostex;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import dataProvider.ConfigProvider;
import gostex.authorization.LogInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogInTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "maximize";
        Selenide.open(ConfigProvider.URL);
    }

    @Test
    public void logInTest() throws InterruptedException {
        new LogInPage()
                .logIn(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD);
    }
}
