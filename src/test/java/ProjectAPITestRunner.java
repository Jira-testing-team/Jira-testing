import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/api/project",
        glue = "classpath:stepDef/api/project",
        plugin = "json:target/cucumber.json",
        tags = "@project"
)
public class ProjectAPITestRunner extends AbstractTestNGCucumberTests {

}
