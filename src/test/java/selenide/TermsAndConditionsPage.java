package selenide;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TermsAndConditionsPage {
    private static Logger logger = Logger.getLogger(TermsAndConditionsPage.class);
    public static By TEXT_UNDER_H3 = By.xpath("//h3[contains(text(), 'Subheading 3')]/following-sibling::p");

    public static String getTextFromH3Paragraph() {
        logger.info("Getting text from H# paragraph");
        return $(TEXT_UNDER_H3).getText();
    }

    @Step("Validating Terms and Conditions text")
    public static void validateText(String text) {
        logger.info("Validating Terms and Conditions text");
        $(TEXT_UNDER_H3).shouldHave(Condition.text(text));
    }
}
