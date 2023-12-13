import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/features/api/user"},
        glue = {"stepDef"}
)
public class UserAPITestRunner extends AbstractTestNGCucumberTests {

}
