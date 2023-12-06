package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPO extends BasePO{
    @FindBy(id = "user-create-email")
    WebElement emailInput;

    @FindBy(id = "user-create-fullname")
    WebElement fullNameInput;

    @FindBy(id = "user-create-username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "user-create-submit")
    WebElement createBtn;

    public void fillOut(String email, String fullName, String username, String password) {
        emailInput.sendKeys(email);
        fullNameInput.sendKeys(fullName);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickCreate() {
        createBtn.click();
    }
}
