import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/ui/user"},
        glue = {"stepDef.ui.user"}
)
public class UserTestRunner extends AbstractTestNGCucumberTests {
}
