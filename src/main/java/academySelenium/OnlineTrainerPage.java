package academySelenium;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;


public class OnlineTrainerPage extends BaseSeleniumPage {

    public TestsPage clickLesson(String numberLesson) {
        driver.findElement(By.xpath(String.format("//a[@href='/ru/trainer/tasks/%s']", numberLesson))).click();
        return new TestsPage();
    }
}
