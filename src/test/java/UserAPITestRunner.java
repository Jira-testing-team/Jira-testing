import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/features/api/user/createUserAPI.feature",
                    "src/test/resources/features/api/user/updateUserAPI.feature",
                    "src/test/resources/features/api/user/assignUserGroupAPI.feature"},
        glue = {"stepDef"},
        tags = "@UserAPI"
)
public class UserAPITestRunner extends AbstractTestNGCucumberTests {
//    @DataProvider(parallel = true)
//    @Override
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
