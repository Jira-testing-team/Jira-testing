import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/ui/workflow",
        glue = "classpath:stepDef/ui/workflow"
)

public class WorkflowUITestRunner extends AbstractTestNGCucumberTests {
}