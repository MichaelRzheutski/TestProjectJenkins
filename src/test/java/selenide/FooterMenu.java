package selenide;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FooterMenu {
    static Logger logger = Logger.getLogger(FooterMenu.class);
    private static By TERMS_AND_CONDITIONS = By.xpath("//td[@class='information']//a[@href='https://litecart.stqa.ru/en/terms-conditions-i-4']");

    @Step("Opening Terms and Conditions page")
    public static void goToTermsAndConditions() {
        logger.info("Opening Terms and Conditions page");
        $(TERMS_AND_CONDITIONS).click();
    }
}
