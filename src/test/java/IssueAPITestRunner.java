import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/api/issue",
        glue = "classpath:stepDef/api/issue"
)
public class IssueAPITestRunner extends AbstractTestNGCucumberTests {

}
