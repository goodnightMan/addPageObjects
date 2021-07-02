package page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {

    public void thisIsOurForm() {
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void typeFirstName(String fName) {
        $("#firstName").val(fName);
    }

    public void typeLastName(String lName) {
        $("#lastName").val(lName);
    }

    public void typeUserEmail(String uMail) {
        $("#userEmail").setValue(uMail);
    }

    public void typeUserNumber(String uNumber) {
        $("#userNumber").setValue(uNumber);
    }

    public void typeUserGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    public void dateOfBirth(String monthOfBirth, String yearOfBirth, String dayOfBirth) {
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format(".react-datepicker__day--0%s", dayOfBirth)).click();
    }

    public void typeSubject(String subject) {
        $("#subjectsInput").val(subject).pressEnter();
    }

    public void typeHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
    }

    public void uploadFile(String picture) {
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
    }

    public void typeCurrentAddress(String currAddr) {
        $("#currentAddress").val(currAddr);
    }

    public void choiceState(String state) {
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
    }

    public void choiceCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    public void submitClick() {
        $("#submit").click();
    }

    //Assert

    public void assertOurDataInForm() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void assertName(String fName, String lName) {
        $x("//td[text()='Student Name']").parent().shouldHave(text(fName + " " + lName));
    }

    public void assertGender(String gender) {
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
    }

    public void assertUserNumber(String uNumber) {
        $x("//td[text()='Mobile']").parent().shouldHave(text(uNumber));
    }

    public void assertDateOfBirth(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
    }

    public void assertSubject(String subject) {
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
    }

    public void assertHobbies(String hobbies) {
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobbies));
    }

    public void assertUploadFile(String picture) {
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
    }

    public void assertCurrentAddress(String currAddr) {
        $x("//td[text()='Address']").parent().shouldHave(text(currAddr));
    }

    public void assertStateAndCity(String state, String city) {
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }
}
