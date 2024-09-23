package co.technical.automation.tasks;

import co.technical.automation.interactions.WaitInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.technical.automation.userinterface.SearchEmailsIU.TXT_EAMIL_SEARCH;
import static co.technical.automation.userinterface.SearchEmailsIU.BTN_SEARCH;
import static co.technical.automation.util.constants.WaitTime.EIGHT;
import static co.technical.automation.util.constants.WaitTime.THREE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ToSearchEmails implements Task {
    private final String text;


    public ToSearchEmails(String text) {
        this.text = text;

    }

    public static ToSearchEmails subject(String text) {
        return instrumented(ToSearchEmails.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitInteraction.waitClass(THREE),
                WaitUntil.the(BTN_SEARCH, isVisible()),
                Click.on(BTN_SEARCH),
                WaitUntil.the(TXT_EAMIL_SEARCH, isVisible()),
                WaitInteraction.waitClass(EIGHT),
                Enter.theValue(text).into(TXT_EAMIL_SEARCH),
                WaitInteraction.waitClass(THREE),
                Click.on(BTN_SEARCH));
        actor.attemptsTo();

    }
}
