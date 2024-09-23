package co.technical.automation.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class LogGmailIU {

    public static final Target TXT_EMAIL = Target.the("TXT to write gmail").locatedBy(
            "//*[@id='identifierId']");
    public static final Target BTN_NEXT = Target.the("BTN going to next").locatedBy(
            "//*[contains(text(),'Siguiente')]");
    public static final Target TXT_PASSWORD = Target.the("TXT to write password").locatedBy(
            "//*[@type='password']");
    public static final Target LBL_RECEIVED = Target.the("Label received").locatedBy(
            "//*[contains(text(),'Redactar')]");
    public static final Target CHECK_ALL_EMAIL = Target.the("select all checkEmail").locatedBy(
            "(//span[@role='checkbox' and @aria-checked='false'])[2]");
    public static final Target LBL_TABLE_SELECT_ONE_EMAIL = Target.the("label to seleto el email").locatedBy(
            "//tr[contains(@class, 'zA') and contains(@class, 'zE') and .//td[7]//img[@title='Tiene archivo adjunto']][{0}]");
    public static final Target LBL_TABLE_SELECT_ALL_EMAIL = Target.the("label to seleto el email").locatedBy(
            "//tr[contains(@class, 'zA') and contains(@class, 'zE')]");

    private LogGmailIU() {


    }
}
