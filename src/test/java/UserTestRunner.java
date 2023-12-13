import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/ui/user"},
        glue = {"stepDef"}
)
public class UserTestRunner extends AbstractTestNGCucumberTests {
}
