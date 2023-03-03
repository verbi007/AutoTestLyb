package academySelenium;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class TestsPage extends BaseSeleniumPage {

    @FindBy(id = "autocompletion-textarea")
    private WebElement textarea;

    @FindBy(css = ".text")
    private WebElement response;

    @FindBy(css = ".check-sql")
    private WebElement enterBtn;

    public TestsPage() {
        PageFactory.initElements(driver, this);
    }

    public TestsPage inputRequest(String request) {
        textarea.sendKeys(request);
        enterBtn.click();
        checkResponse();
        return this;
    }

    public TestsPage checkResponse() {
        Assert.assertEquals(response.getText(), "Решение верно");
        return this;
    }
}
