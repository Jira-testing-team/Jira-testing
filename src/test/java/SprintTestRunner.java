import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/ui/sprint"},
        glue = {"stepDef"}
)
public class SprintTestRunner extends AbstractTestNGCucumberTests {
}
