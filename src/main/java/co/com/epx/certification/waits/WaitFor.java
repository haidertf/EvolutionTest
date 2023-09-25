package co.com.epx.certification.waits;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitFor implements Interaction {

  private final int var;

  protected WaitFor(int var) {

    this.var = var;
  }

  public static WaitFor aTime(int var) {
    return instrumented(WaitFor.class, var);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    new InternalSystemClock().pauseFor(var);

  }
}
