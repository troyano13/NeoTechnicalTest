package co.technical.automation.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static co.technical.automation.userinterface.LogGmailIU.LBL_TABLE_SELECT_ALL_EMAIL;
import static co.technical.automation.userinterface.LogGmailIU.LBL_TABLE_SELECT_ONE_EMAIL;
import static co.technical.automation.userinterface.SearchEmailsIU.*;
import static co.technical.automation.util.constants.WaitTime.FIVE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateFolderInDrive implements Interaction {

    public static CreateFolderInDrive saveAttach() {
        return instrumented(CreateFolderInDrive.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayDate = LocalDate.now().format(formatter);
        String folderName = "Folder_" + todayDate;

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        List<WebElementFacade> unreadEmails = LBL_TABLE_SELECT_ALL_EMAIL.resolveAllFor(actor);

        if (unreadEmails.isEmpty()) {
            System.out.println("No unread emails were found.");
            return;
        }

        for (int i = 0; i < unreadEmails.size(); i++) {
            WebElementFacade email = unreadEmails.get(i);

            System.out.println("Processing mail #" + (i + 1));
            String indexEmail = String.valueOf((i + 1));

            actor.attemptsTo(
                    WaitInteraction.waitClass(FIVE),
                    WaitUntil.the(LBL_TABLE_SELECT_ONE_EMAIL.of(indexEmail), isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(LBL_TABLE_SELECT_ONE_EMAIL.of(indexEmail)),
                    WaitUntil.the(BTN_FIRST_FILE_ATTACH, isVisible()).forNoMoreThan(30).seconds(),  // Esperar hasta que el botón de archivo adjunto sea visible
                    Click.on(BTN_FIRST_FILE_ATTACH),
                    WaitUntil.the(LBL_INDRIVE, isVisible()),
                    Click.on(LBL_INDRIVE),
                    WaitUntil.the(LBL_INDRIVE, isVisible()),
                    Click.on(LBL_INDRIVE),
                    WaitUntil.the(BTN_MY_UNIT, isVisible()),
                    Click.on(BTN_MY_UNIT)
            );
            if (LBL_FOLDER_FOUND.of(folderName).resolveFor(actor).isVisible()) {
                System.out.println("The folder already exists:" + folderName);
                actor.attemptsTo(
                        Click.on(LBL_FOLDER_FOUND.of(folderName)),
                        WaitUntil.the(LBL_CONTINUE_SAVE, isVisible()),
                        Click.on(LBL_CONTINUE_SAVE),
                        WaitUntil.the(LBL_ADD_FILE_TO_FOLDER, isVisible()),
                        Click.on(LBL_ADD_FILE_TO_FOLDER)
                );
            } else {

                actor.attemptsTo(
                        WaitUntil.the(BTN_NEW_FOLDER, isVisible()),
                        Click.on(BTN_NEW_FOLDER),
                        Enter.theValue(folderName).into(TXT_NEW_TITLE),
                        Click.on(TXT_NEW_TITLE),
                        WaitUntil.the(BTN_CREATE, isVisible()),
                        Click.on(BTN_CREATE),
                        WaitUntil.the(LBL_INDRIVE, isVisible()),
                        Click.on(LBL_INDRIVE),
                        Click.on(BTN_MOVE_NEW_FOLDER)
                );
                System.err.println("The folder has been created:" + folderName);
            }
        }

        driver.switchTo().defaultContent();
    }
}
