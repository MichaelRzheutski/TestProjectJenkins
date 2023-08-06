package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import listeners.ScreenshotListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Listeners(ScreenshotListener.class)
public class SelenideTest {
    private final SelenideElement SEARCH_FIELD = $("[name='q']");
    private final SelenideElement SEARCH_BUTTON = $("[name='btnK']");
    private final SelenideElement RESULT_H3 = $("#search a h3");
    private final String EXPECTED_LINK_TEXT = "Hello, world! - Википедия";

    @Test
    public void firstSelenideTest() {
        Configuration.browser = CHROME;
        open("https://www.google.com");

        SEARCH_FIELD.sendKeys("Hello world!");
        SEARCH_BUTTON.click();
        RESULT_H3.shouldHave(innerText(EXPECTED_LINK_TEXT));

        Assert.assertEquals(RESULT_H3.getText(), EXPECTED_LINK_TEXT);
    }
}
