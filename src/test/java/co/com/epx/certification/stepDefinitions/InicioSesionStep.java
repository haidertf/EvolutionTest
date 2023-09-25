package co.com.epx.certification.stepDefinitions;

import co.com.epx.certification.questions.ValidateText;
import co.com.epx.certification.tasks.Browse;
import co.com.epx.certification.tasks.InicioSesionDatosTask;
import co.com.epx.certification.utilities.DataDrivenExcel;
import co.com.epx.certification.utilities.Excel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.epx.certification.userInterface.InicioSesionUI.LBL_DOC_PENDIENTES;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class InicioSesionStep {

    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^Se ingresa a la URL de EpxStandardCore (\\d+)$")
    public void seIngresaALaURLDeEpxStandardCore(int row, DataTable dataExcel) {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String, String>> dataFeature = dataExcel.asMaps(String.class, String.class);
        Excel excel = new Excel(dataFeature.get(0).get("Ruta Excel"), dataFeature.get(0).get("Pestana"), true, row);
        data = dataDriverExcel.leerExcel(excel);

        theActorCalled("actor").wasAbleTo(Browse.openUrl());
    }

    @When("Se diligencia los campos de inicio de sesion")
    public void seDiligenciaLosCamposDeInicioDeSesion() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(InicioSesionDatosTask.inicioSesionDatosTask(data));
    }

    @Then("Se valida el inicio de sesion exitoso")
    public void seValidaElInicioDeSesionExitoso() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().should(seeThat(ValidateText.validateText(LBL_DOC_PENDIENTES), equalTo(data.get("mensajevalidacion"))));
    }

}
