package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private final SelenideElement userFullNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement outputForm = $("#output");
    private final SelenideElement submitButton = $("#submit");

    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#Ad.Plus-970x250-2').remove()");

        return this;
    }

    public TextBoxPage setFullName(String value) {
        userFullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage clickButton() {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        checkResultComponent.checkTableResult(outputForm, key, value);

        return this;
    }
}