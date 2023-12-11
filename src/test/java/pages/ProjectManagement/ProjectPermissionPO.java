package pages.ProjectManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProjectPermissionPO extends pages.BasePO{
//    @FindBy(xpath = "//select[@id='schemeIds_select']")
    private Select schemeSelect;

//    @FindBy(xpath = "//option[@normalise-space()='Scrum Permission Schema']")
//    private WebElement targetScheme;

    @FindBy(id = "associate_submit")
    private WebElement associateBtn;

    public void selectScheme(WebDriver driver, String schemeName){
        //somehow we cannot use @FindBy with Select, or it will be a null pointer
        schemeSelect = new Select (driver.findElement(By.xpath("//select[@id='schemeIds_select']")));
        schemeSelect.selectByVisibleText(schemeName);
        associateBtn.click();
    }

}
