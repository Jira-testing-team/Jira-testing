package stepDef.ui.sprint;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPagePO;

import static org.testng.Assert.*;

public class CompleteSprintSteps {
    private MainPagePO mainPagePO;

    public CompleteSprintSteps() {
        mainPagePO = new MainPagePO();
    }

    @And("I click on three dots of the current active sprint")
    public void I_click_on_three_dots_of_the_current_active_sprint() {
        mainPagePO.clickBacklog();
        mainPagePO.clickThreeDotsForActiveSprint();
    }

    @And("I click on complete sprint and click on complete")
    public void I_click_on_complete_sprint_and_click_on_complete() {
        mainPagePO.clickCompleteSprintBtn();
        mainPagePO.clickConfirmCompleteBtn();
    }

    @Then("I should see there are no active sprints displayed in active sprints tab")
    public void I_should_see_there_are_no_active_sprints_displayed_in_active_sprints_tab() {
        mainPagePO.clickActiveSprintsBtn();
        WebDriver driver = DriverFactory.getDriver();
        String actual = driver.findElement(By.xpath("//h3")).getText();
        assertEquals(actual, "There are no active sprints");
    }
}
