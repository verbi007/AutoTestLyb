package sqlAcademy;


import academySelenium.MainPage;
import core.BaseSeleniumTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class AcademySeleniumTests extends BaseSeleniumTest {

    @BeforeClass
    public void set() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
    }

    @Test
    public void test() {
        new MainPage()
                .clickLogIn()
                .logIn(System.getProperty("login"), System.getProperty("password.academy"))
                .openOnlineTrainerPage()
                .clickLesson("1")
                .inputRequest("select name from Passenger");

    }
}
