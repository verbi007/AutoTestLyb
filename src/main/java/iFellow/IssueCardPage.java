package iFellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class IssueCardPage extends BasePage{
    //status
    private SelenideElement buisnessProcess = $x("//a[@id='opsbar-transitions_more']");
    private SelenideElement doneBtn = $x("//aui-item-link[@id='action_id_31']");
    private SelenideElement inWork = $x("//aui-item-link[@id='action_id_21']");

    private SelenideElement inProgressLink = $x("");
    private SelenideElement inProgressBtn = $x("//*[@name='Transition']");
    private SelenideElement checkStatus = $x("//*[@id='status-val']/span");

    public IssueCardPage selectInProgressStatus() {
        buisnessProcess.click();
        inProgressLink.click();
        inProgressBtn.click();
        checkStatus.shouldBe(Condition.text(""));
        return this;
    }

    public IssueCardPage selectInWork() {
        inWork.click();
        checkStatus.shouldBe(Condition.text("В работе"));
        return this;
    }

    public IssueCardPage selectDoneStatus() {
        buisnessProcess.click();
        doneBtn.click();
        checkStatus.shouldBe(Condition.text("Выполнено"));
        return this;
    }
}
