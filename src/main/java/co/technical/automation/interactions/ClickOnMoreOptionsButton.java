package co.technical.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static co.technical.automation.userinterface.SearchEmailsIU.LBL_MORE_OPCTIONS_EMAIL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOnMoreOptionsButton implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        driver.switchTo().frame("app");

        actor.attemptsTo(
                WaitInteraction.waitClass(20),
                WaitUntil.the(LBL_MORE_OPCTIONS_EMAIL, isVisible()),
                Click.on(LBL_MORE_OPCTIONS_EMAIL)
        );

        WebElement element = driver.findElement(By.cssSelector("[aria-label='Etiquetas']"));

        try {
            element.click();
            System.out.println("Normal click executed.");
        } catch (Exception e) {
            try {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].click();", element);
                System.out.println("Force click executed with JavaScript.");
            } catch (Exception jsEx) {
                System.out.println("Click using JavaScript failed:" + jsEx.getMessage());
            }
        }

        driver.switchTo().defaultContent();
    }

    public static ClickOnMoreOptionsButton on() {
        return new ClickOnMoreOptionsButton();
    }
}
