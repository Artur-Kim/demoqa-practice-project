package other_tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitSoftAssertionsTest extends TestBase {

    @Test
    void searchSoftAssertionsJUnit5Example() {
        open("/selenide/selenide");
        $("#repository-container-header")
                .shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("soft");
        $$("#wiki-pages-box a").findBy(text("SoftAssertions")).click();
        $("[id*=junit5]").scrollTo().ancestor("h4")
                .shouldHave(text("3. Using JUnit5 extend test class:"));
        try {
            $("[id*=junit5]").ancestor("h4").sibling(0)
                    .shouldHave(text(new String(
                            Files.readAllBytes(Paths.get("src/test/resources/text/JUnit5_example.txt")))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}