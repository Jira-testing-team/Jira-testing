import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/ui/group",
        glue = "classpath:stepDef/ui/group"
)

public class GroupUITestRunner extends AbstractTestNGCucumberTests {
}