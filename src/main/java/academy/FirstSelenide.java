package academy;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FirstSelenide extends BaseSelenide {

    private SelenideElement onlineTrainer = $(By.xpath("//a[@href='/ru/trainer']"));

    public OnlineTrainer clickOnlineTrainer() {
        onlineTrainer.click();
        return new OnlineTrainer();
    }
}
