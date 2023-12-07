package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
    public String URL = "http://localhost:8080/login.jsp";
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

}

