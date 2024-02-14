import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "http://the-internet.herokuapp.com";
    }

    @Test
    void dragAndDrop() {
        open("/drag_and_drop");
        $("#column-a").sibling(0).shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").parent().shouldHave(text("B"));
    }
}