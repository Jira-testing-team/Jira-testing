import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/api/project",
        glue = "classpath:stepDef/api/project"
)
public class ProjectAPITestRunner extends AbstractTestNGCucumberTests {

}
