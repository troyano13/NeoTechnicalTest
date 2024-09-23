package co.technical.automation.tasks;

import co.technical.automation.interactions.WaitInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.technical.automation.userinterface.SearchEmailsIU.BTN_GO_TO_TAG;
import static co.technical.automation.util.constants.WaitTime.THREE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ToGoTag implements Task {
    private final String text;

    public ToGoTag(String text) {
        this.text = text;
    }

    public static ToGoTag selectTag(String text) {
        return instrumented(ToGoTag.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_GO_TO_TAG.of(text), isVisible()),
                Click.on(BTN_GO_TO_TAG.of(text)),
                WaitInteraction.waitClass(THREE)

        );
    }
}
