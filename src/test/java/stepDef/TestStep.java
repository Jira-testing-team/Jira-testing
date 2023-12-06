//package stepDef;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import javax.xml.datatype.Duration;
//
//public class TestStep {
//    WebDriver driver;
//    @Given("I get driver")
//    public void i_get_driver() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//    }
//    @Given("I go to google")
//    public void i_go_to_google() throws InterruptedException {
//        driver.navigate().to("https://www.google.com/");
//        Thread.sleep(3000);
//    }
//    @Then("true")
//    public void yes() {
//        System.out.println("done");;
//    }
//}
