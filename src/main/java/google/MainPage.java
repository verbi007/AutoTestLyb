package google;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
    
    @FindBy(xpath = "//input[@type='search']")
    private WebElement inputField;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public ResultSearchPage search(String text) {
        inputField.sendKeys(text, Keys.ENTER);
        return new ResultSearchPage();
    }
}
