package academy;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OnlineTrainer extends BaseSelenide {

    private SelenideElement generationRandomTest = $(".generate-test");


    public TestsPage clickRandomTest() {
        generationRandomTest.click();
        return new TestsPage();
    }
    public TestsPage clickLesson(String numberLesson) {
       $(By.xpath(String.format("//a[@href='/ru/trainer/tasks/%s']", numberLesson))).click();
       return new TestsPage();
    }
}
