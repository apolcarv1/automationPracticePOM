package runner.front;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/feature/front/registro.feature"}
        , glue = {"StepDefinition"}
        , snippets =  CucumberOptions.SnippetType.CAMELCASE)
public class TestRunnersRegistro {
}
