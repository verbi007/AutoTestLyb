package google;

import core.BaseSeleniumTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTest extends BaseSeleniumTest {

    @BeforeClass
    public void initData() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("google.properties"));
    }

    @Test
    public void searchTests() {
        driver.get(System.getProperty("url.google"));

        new MainPage()
                .search("speedtest");
    }
}
