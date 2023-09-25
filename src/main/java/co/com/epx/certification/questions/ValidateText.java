package co.com.epx.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.logging.Logger;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ValidateText implements Question<String> {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ValidateText.class));
    Target element;


    public ValidateText(Target element) {
        this.element = element;
    }

    public static ValidateText validateText(Target element) {
        return new ValidateText(element);

    }

    @Override
    public String answeredBy(Actor actor) {

        String labelField = Text.of(element).answeredBy (actor).toString();
        LOGGER.info("El texto encontrado en el localizador es: " + labelField);
        return labelField;
    }
}
