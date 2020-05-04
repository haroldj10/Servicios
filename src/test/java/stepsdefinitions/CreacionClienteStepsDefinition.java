package stepsdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Cliente;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import questions.ValidarElEstado;
import tasks.Consultar;

import java.util.List;

public class CreacionClienteStepsDefinition {

    @Before
    public void before() {
	    OnStage.setTheStage(OnlineCast.ofStandardActors());
    }

    @Given("^que (.*) consulta el servicio (.*)$")
    public void queConsultaElServicio(String usuario, String url) {
        OnStage.theActorCalled(usuario);
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(url)).remember("url", url);
    }

    @When("^hace el registro con los datos$")
    public void haceElRegistroConLosDatos(List<Cliente> listCliente) {
        OnStage.theActorInTheSpotlight().attemptsTo(Consultar.elServicio(listCliente));
    }

    @When("^hace el logueo con los datos$")
    public void haceElLogueoConLosDatos(List<Cliente> listCliente) {
        OnStage.theActorInTheSpotlight().attemptsTo(Consultar.elServicio(listCliente));
    }


    @Then("^valida el codigo de respuesta (.*)$")
    public void validaElCodigoDeRespuesta(String response) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarElEstado.deLaConsulta(), Matchers.equalTo(response)));
    }
}
