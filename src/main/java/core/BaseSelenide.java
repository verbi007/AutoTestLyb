package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import dataProvider.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public abstract class BaseSelenide {
    public void setUp() throws IOException {
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
