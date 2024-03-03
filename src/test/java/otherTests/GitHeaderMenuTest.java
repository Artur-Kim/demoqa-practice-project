package otherTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHeaderMenuTest extends TestBase {

    @Test
    void fromMainMenuHoverToEnterprizePage() {
        open("http://github.com");
        $(withText("Solutions")).hover();
        $("[href='/enterprise']").click();
        $("#hero-section-brand-heading").parent()
                .shouldHave(text("The AI-powered developer platform. To build, scale, and deliver secure software."));
    }
}