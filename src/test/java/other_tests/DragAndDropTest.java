package other_tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest extends TestBase {

    @Test
    void dragAndDrop() {
        open("/drag_and_drop");
        $("#column-a").sibling(0).shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").parent().shouldHave(text("B"));
    }
}