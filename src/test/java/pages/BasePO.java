package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePO {
    WebDriver driver;
    public BasePO() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public String capitalizeWord(String str){
        String[] words = str.split("\\s");
        StringBuilder capitalizeWord = new StringBuilder();
        for(String word : words){
            String first = word.substring(0,1);
            String second = word.substring(1).toLowerCase();
            capitalizeWord.append(first.toUpperCase()).append(second).append(" ");
        }
        return capitalizeWord.toString().trim();
    }
}
