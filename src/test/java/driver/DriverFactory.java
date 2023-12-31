package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    private static WebDriver createWebDriver() {
        WebDriver webDriver;

        try (FileInputStream input = new FileInputStream("src/test/resources/application.properties")) {
            Properties properties =  new Properties();
          
            properties.load(input);

            switch (properties.getProperty("driver").toLowerCase()) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    webDriver = new ChromeDriver(options);
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                }
                case "safari": {
                    WebDriverManager.safaridriver().setup();
                    webDriver = new SafariDriver();
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Browser type is not supported");
                }
            }
            webDriver.manage().window().maximize();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return webDriver;
    }

    public static WebDriver getDriver() {
        if(driverLocal.get() == null) {
            driverLocal.set(createWebDriver());
        }
        return driverLocal.get();
    }

    public static void teardown() {
      
        if (driverLocal.get() != null) {
            driverLocal.get().quit();
            driverLocal.remove();
        }
    }
}

