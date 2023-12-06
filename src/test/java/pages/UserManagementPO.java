package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserManagementPO extends BasePO{
    @FindBy(id = "create_user")
    WebElement createBtn;

    @FindBy(id = "user_browser_table")
    WebElement userTable;

    public void clickCreate() {
        createBtn.click();
    }

    public boolean hasUser(String username) {
        List<WebElement> rows = userTable.findElements(By.xpath(".//tr"));
        for (int i = 0; i < rows.size(); i++) {
            String tmp = rows.get(i).findElement(By.xpath("//span[@class='username']")).getText();
            if(tmp.equals(username)) {
                return true;
            }
        }
        return false;
    }
}
