package moodle;

import moodle.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class MoodleTest {
    @BeforeClass
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
    }
    @Test
    public void checkLogin() {
        new LoginPage(System.getProperty("url_moodle"))
                .logIn(System.getProperty("username"), System.getProperty("password"))
                .checkText("Школа тестирования");
    }
}
