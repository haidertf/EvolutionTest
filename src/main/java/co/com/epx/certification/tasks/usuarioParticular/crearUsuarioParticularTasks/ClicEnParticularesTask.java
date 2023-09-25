package co.com.epx.certification.tasks.usuarioParticular.crearUsuarioParticularTasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.epx.certification.userInterface.usuarioParticularUI.CrearUsuarioParticularUI.BTN_PARTICULARES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClicEnParticularesTask implements Task {
    public static Performable clicEnParticularesTask() {
        return instrumented(ClicEnParticularesTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_PARTICULARES, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BTN_PARTICULARES)
        );
    }
}
