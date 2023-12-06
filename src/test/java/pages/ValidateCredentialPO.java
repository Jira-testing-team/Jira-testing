package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ValidateCredentialPO extends BasePO{
    @FindBy(id = "login-form-authenticatePassword")
    WebElement passwordInput;

    @FindBy(id = "login-form-submit")
    WebElement confirmBtn;

    public void enterPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickConfirm() {
        confirmBtn.click();
    }
}
