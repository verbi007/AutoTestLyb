package academySelenium;
import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    @FindBy(css = ".link__signin")
    private WebElement logIn;

    public MainPage() {
        driver.get(System.getProperty("url.academy"));
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLogIn() {
        logIn.click();
        return new LoginPage();
    }
}
