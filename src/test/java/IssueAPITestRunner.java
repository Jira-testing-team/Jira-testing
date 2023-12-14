import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/api/issue",
        glue = "classpath:stepDef/api/issue",
        plugin = "json:target/cucumber-issue.json"
)
public class IssueAPITestRunner extends AbstractTestNGCucumberTests {

}
