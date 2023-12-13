package stepDef.ui.sprint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MainPagePO;

import static org.testng.Assert.*;
import java.io.File;

public class DownloadVelocityChartSteps {
    private MainPagePO mainPagePO;

    public DownloadVelocityChartSteps() {
        mainPagePO = new MainPagePO();
    }


    @And("I click on reports tab")
    public void i_click_on_reports_tab() {
        mainPagePO.clickReportsBtn();
    }
    @And("I switch to velocity chart report")
    public void i_switch_to_velocity_chart_report() {
        mainPagePO.switchToVelocityChartReport();
    }
    @And("I apply {string} months timeframe")
    public void i_apply_months_timeframe(String number) {
        mainPagePO.chooseTimeFrame(number);
    }
    @And("I click on save as an image button")
    public void i_click_on_save_as_an_image_button() {
        mainPagePO.downloadFromReportCanvas();
    }
    @Then("I should see the image appear in the target location")
    public void i_should_see_the_image_appear_in_the_target_location() {
        File f = new File("./canvas_image.png");
        assertTrue(f.exists());
    }

}
