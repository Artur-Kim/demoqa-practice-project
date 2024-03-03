package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement previousMonthButton = $("[aria-label='Previous Month']");
    private final SelenideElement nextMonthButton = $("[aria-label='Next Month']");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement dropListState = $("#state");
    private final SelenideElement dropListCity = $("#city");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement tableForm = $(".table-responsive");
    private final SelenideElement tableHeader = $("#example-modal-sizes-title-lg");
    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setPreviousMonth() {
        calendarInput.click();
        previousMonthButton.click();

        return this;
    }

    public RegistrationPage setNextMonth() {
        calendarInput.click();
        nextMonthButton.click();

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        dropListState.click();
        dropListState.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        dropListCity.click();
        dropListCity.$(byText(city)).click();

        return this;
    }

    public RegistrationPage clickButton() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        checkResultComponent.checkTableResult(tableForm, key, value);

        return this;
    }

    public RegistrationPage checkTableHeaderText() {
        tableHeader.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    /**
     * @param value required value "visible" or "not visible"
     * @return this
     */
    public RegistrationPage tableFormVisible(String value) {
        if (value.equals("visible")) {
            tableForm.shouldHave(visible);
        } else if (value.equals("not visible")) {
            tableForm.shouldNotHave(visible);
        } else {
            throw new IllegalArgumentException("Value should be \"visible\" or \"not visible\"");
        }

        return this;
    }

}