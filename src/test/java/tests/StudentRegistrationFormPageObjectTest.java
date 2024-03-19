package tests;

import org.junit.jupiter.api.Test;
import other_tests.TestBase;
import pages.RegistrationPage;

import static utils.RandomUtils.*;
import static utils.RegistrationPageRandomUtils.*;

public class StudentRegistrationFormPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillRegistrationFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setPreviousMonth()
                .setNextMonth()
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .uploadPicture("images/" + imageFile)
                .setAddress(fullTemporaryAddress)
                .setState(state)
                .setCity(city)
                .clickButton()

                .tableFormVisible("visible")
                .checkTableHeaderText()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", imageFile)
                .checkResult("Address", fullTemporaryAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void requiredFields() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .clickButton()

                .tableFormVisible("visible")
                .checkTableHeaderText()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    void fieldsNotFilled() {

        registrationPage.openPage()
                .clickButton()
                .tableFormVisible("not visible");
    }
}