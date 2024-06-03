import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/JiraSmoke.feature",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-html-report.html",
                "json:target/json-reports/cucumber-report.json"
        }
)
public class JiraSmokeE2ECucumberTest extends AbstractTestNGCucumberTests {

}
