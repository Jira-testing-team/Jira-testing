package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
    public String URL = "http://localhost:8080/login.jsp";
    @FindBy(xpath = "//input[@id='login-form-username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='login-form-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login-form-submit']")
    public WebElement loginButton;

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}