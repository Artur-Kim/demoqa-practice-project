package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent {
    public void checkTableResult(SelenideElement element, String key, String value) {
        $(element).$(byText(key)).parent().shouldHave(text(value));
    }
}