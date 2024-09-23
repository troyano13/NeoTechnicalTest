package co.technical.automation.tasks;

import co.technical.automation.interactions.TabUnreadEmails;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ToPutTag implements Task {
    private final String text;


    public ToPutTag(String text) {
        this.text = text;
    }

    public static ToPutTag toEmail(String text) {
        return instrumented(ToPutTag.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                TabUnreadEmails.putLabel(text)
        );
    }
}
