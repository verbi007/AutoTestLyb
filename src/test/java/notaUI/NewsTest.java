package notaUI;

import lira.notaUI.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewsTest {

    @BeforeClass
    public void setUp() throws IOException {
        ConfigInit.config("notaUI.properties", "url.notaUI");
    }

    @Test(testName = "Проверка новости в секции 'Самое важное'")
    public void checkFirstNews() {
        new MainPage()
                .clickFirstNews()
                .checkTitleH1()
                .checkUrl();
    }
}
