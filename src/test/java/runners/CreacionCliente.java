package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="src/test/resources/features/creacion_cliente.feature",
        snippets = SnippetType.CAMELCASE,
        glue = "stepsdefinitions",
        tags = "@creacionCliente")

public class CreacionCliente {
}
