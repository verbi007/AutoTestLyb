package iFellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.*;

public class ProjectTestPage extends BasePage{
    private String summaryNewTest;
    private String descriptionNewTest;
    private String environmentNewTest;

    private SelenideElement issueListLink = $x("//span[@title='Список задач']/..");
    private SelenideElement issueLink = $x("//a[@class='js-key-link']");
    private ElementsCollection issueList = $$x("//div[contains(@class,'ghx-issue-compact')]");
    private ElementsCollection taskCount = $$x("//span[@title='Задача']");
    private SelenideElement testSeleniumTask = $x("//*[@data-issue-id='10463']");
    private SelenideElement searchField = $x("//input[@id='ghx-backlog-search-input']");
    private SelenideElement quickSearch = $x("//*[@id='quickSearchInput']");
    private SelenideElement testSeleniumLink = $x("//a[@href='/browse/TEST-374']");
    private SelenideElement testSeleniumTitleInCard = $x("//*[@title='TestSelenium']/span");
    private SelenideElement testSeleniumTitle = $x("//dd[@id='summary-val']");
    private SelenideElement testSeleniumPriority = $x("//*[@id='priority-val']");
    private SelenideElement testSeleniumVersion = $x("//*[@id='versions-field']/span");
    private SelenideElement createTaskBtn = $x("//a[@id='create_link']");
    private SelenideElement countIssue = $x("//div[@class='ghx-issue-count' and contains(text(), '(ы)')]");
    private SelenideElement showAllLink = $x("//*[@title='Show All']");
    private SelenideElement closePopUpBtn = $x("//button[@class='aui-close-button']");

    //Новая задача
    private SelenideElement sectionTask = $x("//section[@id='create-issue-dialog']");
    private SelenideElement summaryTask = $x("//input[@id='summary']");
    private SelenideElement descriptionField = $x("//body[@data-id='mce_0']");
    private SelenideElement versionSelect = $x("//select[@id='fixVersions']");
    private SelenideElement priorityInput = $x("//*[@id='priority-field']");
    private SelenideElement labelsTextArea = $x("//*[@id='labels-textarea']");
    private SelenideElement environmentField = $x("//body[@data-id='mce_6']");
    private SelenideElement popupConfirmation = $x("//*[contains(@class,'aui-message-success')]");
    private SelenideElement alertSuccess = $x("//*[contains(@class,'issue-created-key')]");

    private SelenideElement createBtn = $x("//section[@id='create-issue-dialog']//input[@id='create-issue-submit']");


    /**
     * Нажать в левом меню ссылку "Список Задач"
     * @return - ProjectTestPage
     */
    public ProjectTestPage clickIssueLink() {
        issueListLink.click();
        return this;
    }


    /**
     * Проверка ошибок в "Списке Задач"
     * @return - ProjectTestPage
     */
    public ProjectTestPage checkCountIssue() {
        //Способ через счетчик в хедере секции
//        int actualCount = Integer.parseInt(countIssue.getText().replaceAll("\\W+", "").trim());
        showAllLink.click();
        int issues = issueList.size();
        int tasks = taskCount.size();
//        System.out.println(tasks + " из " + actualCount);
        System.out.println(tasks + " из " + issues);
        return this;
    }


    /**
     * Нажать на задачу TestSelenium
     * @return - ProjectTestPage
     */
    public ProjectTestPage clickTestSeleniumTask() {
        issueLink.click();
        testSeleniumLink.click();
        testSeleniumTitle.shouldBe(Condition.text("TestSelenium"));
        return this;
    }


    /**
     * Поиск задачи TestSelenium
     * @return - ProjectTestPage
     */
    public ProjectTestPage searchIssue (String issueName) {
        searchField.sendKeys(issueName + Keys.ENTER);
        testSeleniumTitleInCard.shouldBe(Condition.text(issueName));
        return this;
    }

    public IssueCardPage quickSearch(String value) {
        quickSearch.sendKeys(value);
        $x(String.format("//li[@original-title='%s']/a", value)).click();
        return new IssueCardPage();
    }


    /**
     * Проверка приоритета задачи TestSelenium
     * @param priority - приоритет задачи
     * @return - ProjectTestPage
     */
    public ProjectTestPage checkThePriorityTestSelenium (String priority) {
        String actualTitlePriority = testSeleniumPriority.getText().replaceAll("\\W+", "");
        Assertions.assertEquals(priority, actualTitlePriority);
        return this;
    }


    /**
     * Проверка версии TestSelenium
     * @param versionValue - версия задачи
     * @return - ProjectTestPage
     */
    public ProjectTestPage checkTheVersionTestSelenium (String versionValue) {
        testSeleniumVersion.shouldBe(Condition.text(versionValue));
        return this;
    }


    /**
     * Нажать кнопку создать в хедере
     * @return - ProjectTestPage
     */
    public ProjectTestPage clickCreateBtn() {
        createTaskBtn.click();
        return this;
    }


    /**
     * Заполнение новой задачи
     * @param summaryTest - тема задачи
     * @return - ProjectTestPage
     */
    public ProjectTestPage fillTask(String summaryTest) {
        Faker faker = new Faker();
        summaryNewTest = summaryTest;
        descriptionNewTest = faker.lorem().paragraph();
        environmentNewTest = faker.lorem().paragraph();

        switchTo().activeElement();
        summaryTask.sendKeys(summaryTest);

        switchTo().frame("mce_0_ifr");
        descriptionField.sendKeys(descriptionNewTest);
        switchTo().defaultContent();

        versionSelect.selectOptionByValue("10001");
        priorityInput.sendKeys("High" + Keys.ENTER);
        labelsTextArea.sendKeys("test");

        switchTo().frame("mce_6_ifr");
        environmentField.sendKeys(environmentNewTest);
        switchTo().defaultContent();

        createBtn.click();
        closePopUpBtn.click();

        return this;
    }


    /**
     * Выбор задачи из списка по title
     * @param issueName - имя задачи
     * @return - ProjectTestPage
     */
    public ProjectTestPage clickIssueByName(String issueName) {
        $x(String.format("//li[@title='%s']", issueName)).click();
        return this;
    }


    public IssueCardPage clickIssue() {
        issueLink.click();
        return new IssueCardPage();
    }

}
