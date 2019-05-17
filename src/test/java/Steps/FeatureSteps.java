package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class FeatureSteps {

    @Given("Post  operation to create Profile {string}")
    public void CreateProfile(String arg0) {
    }

    @And("Provide  meterId {string} and profileName {string} to create profile")
    public void ProfileParameters(String meterId, String profilename) {
        BDDStyleCode.CreateProfile(meterId, profilename);
    }

    @Given("Get operation to get profile by id {string}")
    public void ProfileById(String url) {
        given().contentType(ContentType.JSON);
    }

    @And("Pass  meter id  {string}")
    public void ProfileByIdInput(String profileId) {
        BDDStyleCode.ProfileById(profileId);

    }

    @Then("I should see  meter id  and name from profiles content")
    public void ProfileByIdOutput() {
    }

    @Given("Get operation to list  all {string}")
    public void GetAllProfiles(String arg0) {
        given().contentType(ContentType.JSON);
    }


    @Then("i should see all meters and name")
    public void ALlProfileOutput() {
        BDDStyleCode.GetAllProfiles();
    }

    @Given("POST operation to Create fraction {string}")
    public void CreateFraction(String arg0) {
    }

    @And("Provide meterId {string} month {string} value {string}")
    public void CreateFractionInput(String meterId, String month, String value) {
        BDDStyleCode.CreationFractions(meterId, month, value);
    }

    @Given("Get operation to list all fraction in a profile {string}")
    public void GetProfileFraction(String arg0) {
    }

    @And("Provide meterId Id {string}")
    public void GetProfileFractionInput(String meterId)
    {
        BDDStyleCode.GetAllProfileFractions(meterId);
    }

    @Given("Get operation to get a single   fraction from fraction list {string}")
    public void GetFractionById(String arg0) {
    }

    @And("I will Provide  fraction id {int}")
    public void GetFractionByIdInput(Integer fractionId) {
        BDDStyleCode.FractionGetbyId(fractionId);
    }


    @Given("Post operation to create meterreadings {string}")
    public void CreateMeterReadings(String arg0) {
    }

    @And("Provide meterId {int} and timestamp {string} month {string} and volume {int}")
    public void CreateMeterReadingsInput(Integer meterId, String timestamp, String month, Integer volume) {
        BDDStyleCode.CreateMeterReadings(meterId,timestamp,month,volume);
    }

    @Given("GET operation to list all {string}")
    public void GetAllMeterReadings(String arg0) {
        BDDStyleCode.MeterReadingsGetALL();
    }

    @Then("I should all meter reading data")
    public void iShouldAllMeterReadingData() {
    }

    @Given("Get operation to get meterReadings By Id {string}")
    public void GetMeterReadingsById(String arg0) {

    }

    @And("Provide meterreading Id to get required meterReading {int}")
    public void GetMeterReadingsByIdInput(Integer meterReadingId) {
        BDDStyleCode.GetMeterReadingById(meterReadingId);
    }

    @Given("Delete operation on meterreadings to delete meterReading {string}")
    public void deleteOperationOnMeterreadingsToDeleteMeterReading(String arg0) {

    }

    @And("I will provide meter {int} and month {string}")
    public void DeleteMeterReadingById(Integer meterId, String monthName) {
        BDDStyleCode.DeleteMeterReadingById(meterId, monthName);
    }


    //Delete
    @Given("I will perform Delete operation on {string}")
    public void DeleteProfileById(String ProfileId) {
    }

    @And("I will pass profile id {string}")
    public void DeleteProfileByIdInput(String ProfileId) {
        BDDStyleCode.DeleteProfileById(ProfileId);
    }

}
