import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x768";
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "http://demoqa.com";
    }

    @Test
    void fillRegistrationFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("iitest@m.ru");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("7925869231");
        $("#dateOfBirthInput").click();
        $("[class*=month-select]").click();
        $("[class*=month-select] [value='5']").click();
        $("[class*=year-select]").click();
        $("[class*=year-select] [value='1989']").click();
        $("[aria-label='Previous Month']").click();
        $("[aria-label='Next Month']").click();
        $("[aria-label*='June 8']").click();
        $("#subjectsInput").setValue("E");
        $("#react-select-2-option-2").click();
        $("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("images/img.png");
        $("#currentAddress").setValue("Test city, house 17. b. 3, f. 5.");
        $(withText("Select State")).scrollTo();
        $(withText("Select State")).click();
        $("#react-select-3-option-3").click();
        $(withText("Select City")).click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("iitest@m.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7925869231"));
        $(".table-responsive").shouldHave(text("8 June,1989"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("img.png"));
        $(".table-responsive").shouldHave(text("Test city, house 17. b. 3, f. 5."));
        $(".table-responsive").shouldHave(text("Rajasthan Jaiselmer"));
    }
}