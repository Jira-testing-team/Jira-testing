import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/ui/issue",
        glue = "classpath:stepDef/ui/issue"
)
public class IssueUITestRunner extends AbstractTestNGCucumberTests {

}
