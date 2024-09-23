package co.technical.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.technical.automation.userinterface.SearchEmailsIU.BTN_GO_TO_RECEIVED;
import static co.technical.automation.userinterface.SearchEmailsIU.LBL_THERE_NOT_RECEIVED;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ToGoToReceived implements Task {
    private final String text;

    public ToGoToReceived(String text) {
        this.text = text;
    }

    public static ToGoToReceived toEmail(String text) {
        return instrumented(ToGoToReceived.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_GO_TO_RECEIVED, isVisible()),
                Click.on(BTN_GO_TO_RECEIVED),
                new ToSearchEmails(text),
                WaitUntil.the(LBL_THERE_NOT_RECEIVED, isVisible())
        );
    }
}
