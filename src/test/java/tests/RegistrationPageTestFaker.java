package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import page.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationPageTestFaker extends TestBase {

    Faker faker = new Faker();

    String fName = faker.name().firstName(),
            lName = faker.name().lastName(),
            uMail = faker.internet().emailAddress(),
            gender = "Other",
            uNumber = faker.number().digits(10),
            monthOfBirth = "April",
            yearOfBirth = "1999",
            dayOfBirth = "27",
            subject = "Arts",
            hobbies = "Music",
            picture = "1.png",
            currAddr = faker.address().streetAddress(),
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
        sleep(1000);
    }
}
