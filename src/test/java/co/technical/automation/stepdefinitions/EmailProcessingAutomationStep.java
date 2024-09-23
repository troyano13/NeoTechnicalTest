package co.technical.automation.stepdefinitions;

import co.technical.automation.exceptions.ExceptionLogAccount;
import co.technical.automation.interactions.CreateFolderInDrive;
import co.technical.automation.questions.Answer;
import co.technical.automation.tasks.*;
import co.technical.automation.util.driver.MyDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.technical.automation.userinterface.LogGmailIU.LBL_RECEIVED;
import static co.technical.automation.util.constants.AnswerWait.TEXTO_RECEIVED;
import static co.technical.automation.util.constants.Url.QA_ENVIRONMENT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class EmailProcessingAutomationStep {


    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^the bot is logged into the email page \"([^\"]*)\" and  \"([^\"]*)\"$")
    public void theBotIsLoggedIntoTheEmailPageAnd(String email, String password) throws Exception {
        theActorCalled("Bot");
        theActorInTheSpotlight().can(BrowseTheWeb.with(MyDriver.web().inPage(QA_ENVIRONMENT)));
        theActorInTheSpotlight().attemptsTo(ToLogEmail.toEmail(email, password));
    }

    @Given("^log in correctly$")
    public void logInCorrectly() throws Exception {
        theActorInTheSpotlight().should(seeThat(Answer.is(LBL_RECEIVED), equalTo(TEXTO_RECEIVED)).orComplainWith(ExceptionLogAccount.class));
    }

    @When("^the bot retrieves emails with the subject \"([^\"]*)\"$")
    public void theBotRetrievesEmailsWithTheSubject(String text) throws Exception {
        theActorInTheSpotlight().attemptsTo(ToSearchEmails.subject(text));
    }

    @When("^it labels those emails as \"([^\"]*)\"$")
    public void itLabelsThoseEmailsAs(String text) throws Exception {
        theActorInTheSpotlight().attemptsTo(ToPutTag.toEmail(text));
    }

    @Then("^the bot downloads the unread documents from the \"([^\"]*)\" emails$")
    public void theBotDownloadsTheUnreadDocumentsFromTheEmails(String text) throws Exception {
        theActorInTheSpotlight().attemptsTo(ToGoTag.selectTag(text));
    }

    @Then("^saves the attachments to a shared folder with the current date$")
    public void savesTheAttachmentsToASharedFolderWithTheCurrentDate() throws Exception {
        CreateFolderInDrive.saveAttach();
    }

    @Then("^verifies that the inbox has no incoming emails \"([^\"]*)\"$")
    public void verifiesThatTheInboxHasNoIncomingEmails(String text) throws Exception {
        theActorInTheSpotlight().attemptsTo(ToGoToReceived.toEmail(text));
    }

    @Then("^the bot finishes by logging out$")
    public void theBotFinishesByLoggingOut() throws Exception {
        theActorInTheSpotlight().attemptsTo(ToLogout.account());
    }

}