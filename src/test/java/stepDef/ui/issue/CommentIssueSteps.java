package stepDef.ui.issue;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.IssuePO;
import pages.LoginPO;

import static org.testng.Assert.assertEquals;

public class CommentIssueSteps {

    private WebDriver driver;
    private IssuePO issuePO;

    private final String content = "123";
    private final String editContent = "345";


    public CommentIssueSteps(){
        issuePO = new IssuePO();
        driver = DriverFactory.getDriver();
    }

    @And("I click on \"add a comment\" and add a comment")
    public void addComment(){
        issuePO.addComment(driver, content);
    }

    @Then("I can see a new comment")
    public void checkComment(){
        assertEquals(issuePO.getCommentContent(driver), content);
    }

    @And("I click on \"Edit\" button and edit the comment")
    public void editComment(){
        issuePO.editComment(driver, content, editContent);
    }

    @Then("I can see a edited comment")
    public void checkCommentAgain(){
        assertEquals(issuePO.getCommentContent(driver), editContent);
    }
}
