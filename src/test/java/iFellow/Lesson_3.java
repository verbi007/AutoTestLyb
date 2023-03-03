package iFellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.awt.*;
import java.io.IOException;

public class Lesson_3 {
    private Faker faker;

    @BeforeClass
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("iFellow.properties"));
        faker = new Faker();
//        Configuration.browserSize = "1920x1080";
        Selenide.open(System.getProperty("url.base"));
    }

    @Test()
    public void lessonThreeTest() throws InterruptedException {
        new SignInPage()
                .logIn(System.getProperty("username"), System.getProperty("password"))
                .clickProjectTest()
                .clickIssueLink()
                .checkCountIssue()
                .searchIssue("TestSelenium")
                .clickTestSeleniumTask()
                .checkThePriorityTestSelenium("Medium")
                .checkTheVersionTestSelenium("Version 2.0")
                .clickCreateBtn();

    }

    @Test(testName = "Создание новой задачи и изменение статусов")
    public void createNewTask() {
        String summaryIssue = faker.lebowski().character();
        new SignInPage()
                .logIn(System.getProperty("username"), System.getProperty("password"))
                .clickProjectTest()
                .clickCreateBtn()
                .fillTask(summaryIssue)
                .quickSearch(summaryIssue)
                .selectInProgressStatus()
                .selectInWork()
                .selectInProgressStatus();
    }

}
