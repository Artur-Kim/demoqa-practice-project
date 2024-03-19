package tests;

import org.junit.jupiter.api.Test;
import other_tests.TestBase;
import pages.TextBoxPage;

import static utils.RandomUtils.*;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillAllTextBoxForm() {
        textBoxPage.openPage()
                .setFullName(firstName + " " + lastName)
                .setEmail(email)
                .setCurrentAddress(fullTemporaryAddress)
                .setPermanentAddress(fullPermanentAddress)
                .clickButton()

                .checkResult("Name:", firstName + " " + lastName)
                .checkResult("Email:", email)
                .checkResult("Current Address :", fullTemporaryAddress)
                .checkResult("Permananet Address :", fullPermanentAddress);
    }
}