package co.com.epx.certification.tasks.usuarioParticular.crearUsuarioParticularTasks;

import co.com.epx.certification.utilities.DataDrivenExcel;
import co.com.epx.certification.waits.WaitFor;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.util.HashMap;
import java.util.Map;

import static co.com.epx.certification.userInterface.usuarioParticularUI.CrearUsuarioParticularUI.*;

public class CamposObligatoriosTask implements Task {

    static DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();

    public CamposObligatoriosTask(Map<String, String> data) {
        this.data = data;
    }

    public static Performable camposObligatoriosTask(Map<String, String> data) {
        return Instrumented.instanceOf(CamposObligatoriosTask.class).withProperties(data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(MNU_TIPO_IDETIFICACION, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(),
                Click.on(MNU_TIPO_IDETIFICACION),
                Enter.theValue(data.get("tipoDocumento")).into(TXT_TIPO_IDETIFICACION).thenHit(Keys.ENTER),
                WaitFor.aTime(2000),
                Enter.theValue(data.get("numeroDocumento")).into(TXT_NUMERO_IDENTIFICACION),
                Enter.theValue(data.get("primerNombre")).into(TXT_PRIMER_NOMBRE),
                Enter.theValue(data.get("primerApellido")).into(TXT_PRIMER_APELLIDO),
                Enter.theValue(data.get("estrato")).into(TXT_ESTRATO)
        );
    }
}
