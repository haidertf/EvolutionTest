package co.com.epx.certification.tasks.usuarioParticular.crearUsuarioParticularTasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.epx.certification.userInterface.usuarioParticularUI.CrearUsuarioParticularUI.BTN_NUEVO_CONTACTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClicEnNuevoContactoTask implements Task {
    public static Performable clicEnNuevoContactoTask() {
        return instrumented(ClicEnNuevoContactoTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_NUEVO_CONTACTO, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BTN_NUEVO_CONTACTO)
        );
    }
}
