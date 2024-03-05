package tests;

import org.junit.jupiter.api.Test;
import other_tests.TestBase;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillAllTextBoxForm() {
        textBoxPage.openPage()
                .setFullName("Ivanov Ivan")
                .setEmail("awurgnpagu@mef.aw")
                .setCurrentAddress("Test city, house 17. b. 3, f. 5.")
                .setPermanentAddress("Test city 2, house 1. b. 6, f. 9.")
                .clickButton()

                .checkResult("Name:", "Ivanov Ivan")
                .checkResult("Email:", "awurgnpagu@mef.aw")
                .checkResult("Current Address :", "Test city, house 17. b. 3, f. 5.")
                .checkResult("Permananet Address :", "Test city 2, house 1. b. 6, f. 9.");
    }

}