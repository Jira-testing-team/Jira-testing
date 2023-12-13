import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/ui/project",
        glue = "classpath:stepDef/ui/project"
)

public class ProjectUITestRunner extends AbstractTestNGCucumberTests {

}
