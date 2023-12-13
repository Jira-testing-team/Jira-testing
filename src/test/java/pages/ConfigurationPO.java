package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ConfigurationPO extends BasePO {
    @FindBy(xpath = "//a[normalize-space()='Columns']")
    public WebElement columnsButton;

    public void clickColumnsButton() {columnsButton.click();}
}