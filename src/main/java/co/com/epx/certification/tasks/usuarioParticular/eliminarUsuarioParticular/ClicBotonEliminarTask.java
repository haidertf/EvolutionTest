package co.com.epx.certification.tasks.usuarioParticular.eliminarUsuarioParticular;

import co.com.epx.certification.waits.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static co.com.epx.certification.userInterface.usuarioParticularUI.EliminarUsuarioParticularUI.BTN_ELIMINAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ClicBotonEliminarTask implements Task {

    public static Performable clicBotonEliminarTask() {
        return instrumented(ClicBotonEliminarTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_ELIMINAR)
        );

        actor.attemptsTo(
                WaitUntil.the(ExpectedConditions.alertIsPresent())
        );

        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }
}
