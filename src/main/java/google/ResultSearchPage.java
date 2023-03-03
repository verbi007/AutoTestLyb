package google;

import core.BaseSeleniumPage;
import org.openqa.selenium.support.PageFactory;

public class ResultSearchPage extends BaseSeleniumPage {
    public ResultSearchPage() {
        PageFactory.initElements(driver, this);
    }
}
