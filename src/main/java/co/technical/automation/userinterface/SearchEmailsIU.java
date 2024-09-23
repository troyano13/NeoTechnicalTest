package co.technical.automation.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class SearchEmailsIU {

    public static final Target TXT_EAMIL_SEARCH = Target.the("TXT to write Subject to search").locatedBy(
            "//input[@placeholder='Buscar correo']");
    public static final Target BTN_SEARCH = Target.the("BTN going to search").locatedBy(
            "//button[@aria-label='Buscar correo']");
    public static final Target LBL_EMAIL_UNREAD = Target.the("See email unread").locatedBy(
            "/html/body/div[6]/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div/div[1]/div/div[2]/div[4]/div[1]/div/table/tbody/tr[@class='zA zE' and contains(., 'no leída')]");
    public static final Target LBL_NEW_TAG = Target.the("Label put name label ").locatedBy(
            "//div[@aria-label='Nueva etiqueta']");
    public static final Target LBL_MORE_OPCTIONS_EMAIL = Target.the("Label more option to email").locatedBy(
            "//div[@aria-label='Etiquetas']");
    public static final Target LBL_SELECT_TAG = Target.the("Label to select tag to put").locatedBy(
            "//div[contains(text(),'{0}')]");
    public static final Target TXT_NAME_NEW_TAG = Target.the("Into name tag ").locatedBy(
            "//input[@type='text' and @class='qdOxv-K0-wGMbrd']");
    public static final Target BTN_CREATE_NEW_TAG = Target.the("Button create new tag").locatedBy(
            "//button[.//span[text()='Crear']]");
    public static final Target BTN_GO_TO_TAG = Target.the("Button go to tag").locatedBy(
            "[aria-label^='{0}']");
    public static final Target BTN_FIRST_FILE_ATTACH = Target.the("Label select first file attach").locatedBy(
            "//span[contains(@class, 'aZo') and contains(@class, 'N5jrZb')]");
    public static final Target LBL_FOLDER_FOUND = Target.the("Label to found the old folder").locatedBy(
            "//div//*[contains(text(),'{0}')]");
    public static final Target LBL_CONTINUE_SAVE = Target.the("Label to save").locatedBy(
            "//div//*[contains(text(),'Continuar')]");
    public static final Target LBL_ADD_FILE_TO_FOLDER = Target.the("Label to add to new folder").locatedBy("//*[@id='yDmH0d']/c-wiz//c-wiz/span/div//c-wiz/span/span/div[4]//div//*[contains(text(),'Añadir')]");
    public static final Target LBL_INDRIVE = Target.the("Label going to Indrive").locatedBy(
            "//*[@data-tooltip='Añadir a Mi unidad']");
    public static final Target BTN_NEW_FOLDER = Target.the("Button to create new folder").locatedBy(
            "//*[@id='yDmH0d']//div[2]/div[1]/span/button");
    public static final Target BTN_MY_UNIT = Target.the("Btn my unit").locatedBy(
            "//*[@data-tooltip='Mi unidad']");
    public static final Target TXT_NEW_TITLE = Target.the("Into new title folder").locatedBy(
            "//*[@id='yDmH0d']/c-wiz//form/div/div");
    public static final Target BTN_CREATE = Target.the("Button to create new Folder").locatedBy(
            "//span//*[contains(text(),'Crear')]");
    public static final Target BTN_MOVE_NEW_FOLDER = Target.the("Button to add a folder").locatedBy(
            "//button[.//span[contains(text(), 'Mover')]]");
    public static final Target BTN_GO_TO_RECEIVED = Target.the("Button go to received").locatedBy(
            "a[aria-label^='Recibidos']");
    public static final Target LBL_THERE_NOT_RECEIVED = Target.the("Label there not received").locatedBy(
            "//td[text()='No hay conversaciones con esta etiqueta.']");
    public static final Target BTN_GO_TO_ACCOUNT = Target.the("Label go to account").locatedBy(
            "a[aria-label*='Cuenta de Google']");
    public static final Target BTN_LOGOUT = Target.the("Label go to account").locatedBy(
            "a[href*='Logout']");

    private SearchEmailsIU() {

    }
}


