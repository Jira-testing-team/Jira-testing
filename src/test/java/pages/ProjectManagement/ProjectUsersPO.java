package pages.ProjectManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ProjectUsersPO extends BasePO {
    @FindBy(xpath = "//span[contains(text(),'Add users to a role')]/../..")
    private WebElement addUserToARoleBtn;
    @FindBy(xpath = "//div[@class='multi-select css-2b097c-container']")
    private WebElement usernameInput;
    @FindBy(xpath = "//div[@class=' css-2b097c-container']")
    private WebElement roleInput;
    @FindBy(xpath = "//button[@form='ADD_USER_OR_GROUP_FORM']")
    private WebElement addBtn;

    @FindBy(xpath = "//tbody")
    private WebElement usersTable;

    private List<List<String>> usersTableContent;

    public void clickAddBtn(){addUserToARoleBtn.click();}

    public void addUser(String username, String role){
        usernameInput.click();
        WebElement usernameInputSpan = usernameInput.findElement(By.xpath("//input"));
        usernameInputSpan.sendKeys(username);
        usernameInput.findElement(By.xpath(".//following::div[@id='react-select-2-option-0']")).click();

        roleInput.click();
        WebElement roleInputSpan = roleInput.findElement(By.xpath("//input"));
        roleInputSpan.sendKeys(role);
        roleInput.findElement(By.xpath(".//following::div[@id='react-select-3-option-1']")).click();

        addBtn.click();
    }

    private void updateUsersTableContent(){
        this.usersTableContent = usersTable.findElements(By.xpath(".//tr"))
                .stream()
                .map(row -> {
                    WebElement tdUser = row.findElement(By.xpath(".//td[1]"));
                    WebElement tdRole = row.findElement(By.xpath(".//td[3]"));
                    WebElement spanRole = tdRole.findElement(By.xpath(".//span[@class='css-t5emrf']"));
                    return Arrays.asList(tdUser.getText(), spanRole.getText());
                })
                .collect(Collectors.toList());
    }

    public boolean checkUserByName(String username){
        updateUsersTableContent();
        //find name in list
        for(List<String> l: this.usersTableContent){
            if(l.get(0).contains(username))
                return true;
        }
        return false;
    }

    public String getUserRole(String username){
        if(!checkUserByName(username)){
            return null;
        }else{
            for(List<String> l: this.usersTableContent){
                //find user element
                if(l.get(0).contains(username)){
                    //find role string
                    return l.get(1);
                }
            }
        }
        return null;
    }

}
