import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/api/group",
        glue = "classpath:stepDef/api/group",
        plugin = ("json:target/cucumber-reports/cucumber.json"),
        tags = "@api"
)

public class GroupAPITestRunner extends AbstractTestNGCucumberTests {
}