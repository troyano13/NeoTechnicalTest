package co.technical.automation.tasks;

import co.technical.automation.interactions.WaitInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.technical.automation.userinterface.LogGmailIU.*;
import static co.technical.automation.userinterface.LogGmailIU.BTN_NEXT;
import static co.technical.automation.util.constants.WaitTime.FIVE;
import static co.technical.automation.util.constants.WaitTime.THREE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ToLogEmail implements Task {
    private final String email;
    private final String password;


    public ToLogEmail(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static ToLogEmail toEmail(String email, String password) {
        return instrumented(ToLogEmail.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(TXT_EMAIL),
                Click.on(BTN_NEXT),
                WaitInteraction.waitClass(THREE),
                WaitUntil.the(TXT_PASSWORD, isVisible()),
                Enter.theValue(password).into(TXT_PASSWORD),
                WaitUntil.the(BTN_NEXT, isVisible()),
                Click.on(BTN_NEXT),
                WaitInteraction.waitClass(FIVE)
        );
    }
}
