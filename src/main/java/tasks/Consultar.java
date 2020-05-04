package tasks;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Cliente;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import utils.Archivos;

import java.util.List;

public class Consultar implements Task {

    private static final String RUTA = "src/test/resources/mensajes/";

    private RequestSpecification request;
    private Response response;

    private List<Cliente> listCliente;

    public Consultar(List<Cliente> listCliente) {
        this.listCliente = listCliente;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String url = OnStage.theActorInTheSpotlight().recall("url");
        String mensaje = Archivos.cargarArchivo(RUTA.concat("cliente.json")).replace("CORREO_USUARIO", listCliente.get(0).getEmail()).replace("PASSWORD_USUARIO",listCliente.get(0).getPassword());
        request = RestAssured.given().body(mensaje).relaxedHTTPSValidation("TLS").header("Content-Type", "application/json");
        response = request.when().post(url);
        System.out.println(response.prettyPrint());
        OnStage.theActorInTheSpotlight().remember("statusCode", Integer.toString(response.getStatusCode()));
        OnStage.theActorInTheSpotlight().remember("valorRespuesta", response.toString());

    }

    public static Consultar elServicio(List<Cliente> listCliente){
        return new Consultar(listCliente);
    }
}
