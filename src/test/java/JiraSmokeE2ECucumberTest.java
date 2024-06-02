import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html"},
        monochrome = true
)
public class JiraSmokeE2ECucumberTest extends AbstractTestNGCucumberTests {

}
