package co.com.epx.certification.tasks;

import co.com.epx.certification.userInterface.InicioSesionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Browse implements Task {

    InicioSesionUI url;

    public static Browse openUrl() {
        return instrumented(Browse.class);
    }

    @Step("{0} navega a la url ")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(url)
        );
    }
}
