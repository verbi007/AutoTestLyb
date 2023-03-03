package iFellow;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage{
    private SelenideElement projectLink = $x("//a[@id='browse_link']");
    private SelenideElement testProjectLink = $x("//a[@id='admin_main_proj_link_lnk']");


    /**
     * Перейти в проект Test
     * @return - ProjectTestPage
     */
    public ProjectTestPage clickProjectTest() {
        projectLink.click();
        testProjectLink.click();
        return new ProjectTestPage();
    }
}
