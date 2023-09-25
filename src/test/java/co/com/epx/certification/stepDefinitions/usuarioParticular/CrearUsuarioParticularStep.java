package co.com.epx.certification.stepDefinitions.usuarioParticular;

import co.com.epx.certification.questions.ValidateText;
import co.com.epx.certification.tasks.usuarioParticular.crearUsuarioParticularTasks.*;
import co.com.epx.certification.utilities.DataDrivenExcel;
import co.com.epx.certification.utilities.Excel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.epx.certification.userInterface.usuarioParticularUI.CrearUsuarioParticularUI.MNS_CREACION_USUARIO_EXITOSO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CrearUsuarioParticularStep {


    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();

    @When("Se da clic en el menu Personalizar")
    public void seDaClicEnElMenuPersonalizar() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(ClicEnPersonalizarTask.clicEnPersonalizarTask());
    }

    @When("Se da clic en particulares")
    public void seDaClicEnParticulares() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(ClicEnParticularesTask.clicEnParticularesTask());
    }

    @When("Se da clic en el boton Nuevo Contacto")
    public void seDaClicEnElBotonNuevoContacto() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(ClicEnNuevoContactoTask.clicEnNuevoContactoTask());
    }

    @When("^Se diligencia los campos obligatorios (\\d+)$")
    public void seDiligenciaLosCamposObligatorios(int row, DataTable dataExcel) {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String, String>> dataFeature = dataExcel.asMaps(String.class, String.class);
        Excel excel = new Excel(dataFeature.get(0).get("Ruta Excel"), dataFeature.get(0).get("Pestana"), true, row);
        data = dataDriverExcel.leerExcel(excel);

        theActorInTheSpotlight().attemptsTo(CamposObligatoriosTask.camposObligatoriosTask(data));
    }

    @When("Se da clic en Guardar")
    public void seDaClicEnGuardar() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(ClicEnGuardarTask.clicEnGuardarTask());
    }

    @Then("Se valida la pantalla de creacion exitosa")
    public void seValidaLaPantallaDeCreacionExitosa() {
        // Write code here that turns the phrase above into concrete actions
        WaitUntil.the(MNS_CREACION_USUARIO_EXITOSO, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds();
        theActorInTheSpotlight().should(seeThat(ValidateText.validateText(MNS_CREACION_USUARIO_EXITOSO), equalTo(data.get("creacionUsuarioExitosa"))));
    }

}
