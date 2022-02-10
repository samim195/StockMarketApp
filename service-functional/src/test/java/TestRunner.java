import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:reports/report.html"},
        glue = "uk.home.stockfunctional",
        features = "src/test/resources")
public class TestRunner {}
