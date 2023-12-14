import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "classpath:features/api/user",
        glue = "classpath:stepDef/api/user",
        plugin = "json:target/cucumber-user.json"
)
public class UserAPITestRunner extends AbstractTestNGCucumberTests {

}
