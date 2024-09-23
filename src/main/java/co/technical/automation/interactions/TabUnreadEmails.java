package co.technical.automation.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.technical.automation.userinterface.LogGmailIU.CHECK_ALL_EMAIL;
import static co.technical.automation.userinterface.SearchEmailsIU.*;
import static co.technical.automation.util.constants.WaitTime.FIVE;
import static co.technical.automation.util.constants.WaitTime.THREE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TabUnreadEmails implements Interaction {

    private String text;

    public TabUnreadEmails(String text) {
        this.text = text;
    }

    public static TabUnreadEmails putLabel(String text) {
        return instrumented(TabUnreadEmails.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        boolean elementsVisible = true;
        while (elementsVisible) {

            List<WebElementFacade> unreadEmails = LBL_EMAIL_UNREAD.resolveAllFor(actor);

            if (unreadEmails.isEmpty()) {
                elementsVisible = false;
                actor.attemptsTo(

                        WaitUntil.the(CHECK_ALL_EMAIL, isVisible()),
                        Click.on(CHECK_ALL_EMAIL),
                        Check.whether(LBL_SELECT_TAG.of(text).resolveFor(actor).isVisible()).andIfSo(
                                 WaitUntil.the(LBL_SELECT_TAG.of(text), isVisible()),
                                 Click.on(LBL_SELECT_TAG.of(text))
                        ).otherwise(
                                WaitUntil.the(LBL_NEW_TAG, isVisible()),
                                Click.on(LBL_NEW_TAG),
                                WaitUntil.the(TXT_NAME_NEW_TAG, isVisible()),
                                Enter.theValue(text).into(TXT_NAME_NEW_TAG),
                                WaitUntil.the(BTN_CREATE_NEW_TAG, isVisible()),
                                Click.on(BTN_CREATE_NEW_TAG),
                                WaitInteraction.waitClass(FIVE)),
                        ClickOnMoreOptionsButton.on(),
                        WaitUntil.the(LBL_SELECT_TAG.of(text), isVisible()),
                        Click.on(LBL_SELECT_TAG.of(text)),
                        WaitInteraction.waitClass(THREE));

                System.out.println("No more visible elements to unread**");
                break;
            }

        }


    }

}
