package co.com.epx.certification.tasks.usuarioParticular.eliminarUsuarioParticular;

import co.com.epx.certification.utilities.DataDrivenExcel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.HashMap;

import static co.com.epx.certification.userInterface.usuarioParticularUI.EliminarUsuarioParticularUI.TXT_USUARIO_A_ELIMINAR;

public class DatosUsuarioEliminarTask implements Task {

    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    String data = String.valueOf(new HashMap<String, String>());

    public DatosUsuarioEliminarTask(String data) {
        this.data = data;
    }

    public static Performable datosUsuarioEliminarTask(String data) {
        return Instrumented.instanceOf(DatosUsuarioEliminarTask.class).withProperties(data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_USUARIO_A_ELIMINAR, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(data).into(TXT_USUARIO_A_ELIMINAR)
        );
    }
}
