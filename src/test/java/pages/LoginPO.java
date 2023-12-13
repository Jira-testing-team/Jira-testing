package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
    public String URL = "http://localhost:8080/Dashboard.jspa";
    @FindBy(id = "login-form-username")
    private WebElement usernameInput;

    @FindBy(id = "login-form-password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginBtn;


    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void slowLogin(String username, String password) throws InterruptedException {
        usernameInput.sendKeys(username);
        Thread.sleep(1000);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}

