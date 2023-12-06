package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public abstract class BasePO {
    public BasePO() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
}
