package co.com.epx.certification.tasks;

import co.com.epx.certification.utilities.DataDrivenExcel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.HashMap;
import java.util.Map;

import static co.com.epx.certification.userInterface.InicioSesionUI.*;

public class InicioSesionDatosTask implements Task {

    static DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();

    public InicioSesionDatosTask(Map<String, String> data) {
        this.data = data;
    }

    public static Performable inicioSesionDatosTask(Map<String, String> data) {
        return Instrumented.instanceOf(InicioSesionDatosTask.class).withProperties(data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_NOMBRE_USUARIO, WebElementStateMatchers.isVisible()).forNoMoreThan(5000).milliseconds(),
                Enter.theValue(data.get("usuario")).into(TXT_NOMBRE_USUARIO),
                Click.on(TXT_CONTRASENA2),
                Enter.theValue(data.get("contrasena")).into(TXT_CONTRASENA1),
                Click.on(BTN_INGRESAR)
        );
    }
}
