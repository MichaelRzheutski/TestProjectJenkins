package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import listeners.ScreenshotListener;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static selenide.TermsAndConditionsPage.TEXT_UNDER_H3;

@Listeners(ScreenshotListener.class)
public class TermsAndConditionsTest {
    Logger logger = Logger.getLogger(TermsAndConditionsTest.class);
    String EXPECTED_TEXT = "In in massa accumsan augue accumsan facilisis non eget dui. Ut volutpat nisl urna, ac dapibus ipsum fermentum iaculis. Donec sed lorem metus. Donec gravida et risus et consectetur. Proin aliquet, ipsum in faucibus condimentum, orci sapien sollicitudin mi, vitae molestie nunc odio vitae libero. Nullam pretium velit in sem sagittis, et facilisis mi fermentum. Aenean varius sed est et tincidunt. Praesent non imperdiet ligula.";


    @BeforeMethod
    public void setup() {
        Configuration.remote = "http://192.168.100.2:4444/wd/hub";

        logger.debug("Configuring to run Chrome");
        Configuration.browser = CHROME;

        logger.debug("Setting resolution to 1920x1080");
        Configuration.browserSize = "1920x1080";

        logger.info("Opening main URL");
        open("https://litecart.stqa.ru/en/");
    }

    @Description("This test verifies that the text on the Terms and Conditions page is as expected")
    @Test
    public void textUnderH3ParagraphOnTermsAndConditionsPageTest() {
        FooterMenu.goToTermsAndConditions();
        TermsAndConditionsPage.validateText(EXPECTED_TEXT);

        Assert.assertEquals($(TEXT_UNDER_H3).getText(), EXPECTED_TEXT);
    }
}
