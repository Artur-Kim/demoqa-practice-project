package tests;

import org.junit.jupiter.api.Test;
import other_tests.TestBase;
import pages.RegistrationPage;

public class StudentRegistrationFormPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillRegistrationFormTest() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("iitest@m.ru")
                .setGender("Male")
                .setUserNumber("7925869231")
                .setPreviousMonth()
                .setNextMonth()
                .setDateOfBirth("8", "June", "1989")
                .setSubject("Compu")
                .setHobbies("Reading")
                .uploadPicture("images/img.png")
                .setAddress("Test city, house 17. b. 3, f. 5.")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .clickButton()

                .tableFormVisible("visible")
                .checkTableHeaderText()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "iitest@m.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7925869231")
                .checkResult("Date of Birth", "8 June,1989")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "img.png")
                .checkResult("Address", "Test city, house 17. b. 3, f. 5.")
                .checkResult("State and City", "Rajasthan Jaiselmer");
    }

    @Test
    void requiredFields() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGender("Male")
                .setUserNumber("7925869231")
                .clickButton()

                .tableFormVisible("visible")
                .checkTableHeaderText()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7925869231");
    }

    @Test
    void fieldsNotFilled() {

        registrationPage.openPage()
                .clickButton()
                .tableFormVisible("not visible");
    }

}