import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHeaderMenuTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void fromMainMenuHoverToEnterprizePage() {
        open("http://github.com");
        $(withText("Solutions")).hover();
        $("[href='/enterprise']").click();
        $("#hero-section-brand-heading").parent()
                .shouldHave(text("The AI-powered developer platform. To build, scale, and deliver secure software."));
    }
}