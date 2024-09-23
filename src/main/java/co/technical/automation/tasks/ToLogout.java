package co.technical.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static co.technical.automation.userinterface.SearchEmailsIU.BTN_GO_TO_ACCOUNT;
import static co.technical.automation.userinterface.SearchEmailsIU.BTN_LOGOUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ToLogout implements Task {


    public static ToLogout account() {
        return instrumented(ToLogout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
        actor.attemptsTo(WaitUntil.the(BTN_GO_TO_ACCOUNT, isVisible()),
                Click.on(BTN_GO_TO_ACCOUNT),
                WaitUntil.the(BTN_LOGOUT, isVisible()),
                Click.on(BTN_LOGOUT)
        );

        driver.switchTo().defaultContent();
    }
}
