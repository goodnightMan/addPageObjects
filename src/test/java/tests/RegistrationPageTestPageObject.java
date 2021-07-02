package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;

public class RegistrationPageTestPageObject extends TestBase {
    String fName = "Bill",
            lName = "Yellow",
            uMail = "somewhere@la.fa",
            gender = "Other",
            uNumber = "4432568000",
            monthOfBirth = "April",
            yearOfBirth = "1999",
            dayOfBirth = "27",
            subject = "Arts",
            hobbies = "Music",
            picture = "1.png",
            currAddr = "home",
            state = "Rajasthan",
            city = "Jaipur";

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        openUrl();

        registrationPage.thisIsOurForm();
        registrationPage.typeFirstName(fName);
        registrationPage.typeLastName(lName);
        registrationPage.typeUserEmail(uMail);
        registrationPage.typeUserGender(gender);
        registrationPage.typeUserNumber(uNumber);
        registrationPage.dateOfBirth(monthOfBirth, yearOfBirth, dayOfBirth);
        registrationPage.typeSubject(subject);
        registrationPage.typeHobbies(hobbies);
        registrationPage.uploadFile(picture);
        registrationPage.typeCurrentAddress(currAddr);
        registrationPage.choiceState(state);
        registrationPage.choiceCity(city);
        registrationPage.submitClick();

        //Assert
        registrationPage.assertOurDataInForm();
        registrationPage.assertName(fName, lName);
        registrationPage.assertGender(gender);
        registrationPage.assertUserNumber(uNumber);
        registrationPage.assertDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationPage.assertSubject(subject);
        registrationPage.assertHobbies(hobbies);
        registrationPage.assertUploadFile(picture);
        registrationPage.assertCurrentAddress(currAddr);
        registrationPage.assertStateAndCity(state, city);
    }
}

