package Steps;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class BDDStyleCode {


    public static void CreateProfile(String meterId, String profilename) {

        HashMap<String, Object> profile1 = new HashMap<String, Object>();
        profile1.put("meterId", meterId);
        profile1.put("name", profilename);
        Gson gson = new Gson();
        String jsonData = gson.toJson(profile1);
        given().
                contentType(ContentType.JSON)
                .with()
                .body(jsonData)
                .when()
                .post("http://localhost:8080/profiles")
                .then()
                .statusCode(201);
    }

    public static void ProfileById(String profileId) {
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:8080/profiles/%s", profileId))
                .then()
                .statusCode(200);
    }

    public static void GetAllProfiles() {
        given().
                contentType(ContentType.JSON)
                .when()
                .get("http://localhost:8080/profiles")
                .then().body("totalPages", is(1))
                .statusCode(200);
    }


    public static void CreationFractions(String meterId, String month, String value) {

        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        json.put("month", month);
        json.put("value", value);
        Object data = jsonArray.put(json);
        given().
                contentType(ContentType.JSON)
                .with()
                .pathParam("meterId", meterId)
                .body(data.toString())
                .post("http://localhost:8080/profiles/{meterId}/fractions")
                .then()
                .statusCode(201);
    }

    public static void GetAllProfileFractions(String meterId) {
        given().contentType(ContentType.JSON)
                .when()
                .pathParam("meterId", meterId)
                .when().get("http://localhost:8080/profiles/{meterId}/fractions")
                .then()
                .statusCode(200);
    }

    public static void FractionGetbyId(Integer fractionId) {
        given().
                contentType(ContentType.JSON)
                .when()
                .pathParam("fractionId", fractionId)
                .when()
                .get("http://localhost:8080/profiles/fractions/{fractionId}")
                .then()
                .statusCode(200);

    }

    public static void CreateMeterReadings(Integer meterId, String timestamp, String month, Integer volume) {

        JSONObject obj = new JSONObject();
        JSONArray objArray = new JSONArray();
        obj.put("meterId", meterId);
        obj.put("timestamp", timestamp);
        obj.put("month", month);
        obj.put("volume", volume);
        Object arrayData = objArray.put(obj);
        System.out.println(arrayData);
        given()
                .contentType(ContentType.JSON)
                .with()
                .body(arrayData.toString())
                .when()
                .post("http://localhost:8080/meterreadings/list")
                .then().statusCode(201);
    }


    public static void MeterReadingsGetALL() {
        System.out.println("All meter reading");
        given().contentType(ContentType.JSON)
                .when()
                .when().get(String.format("http://localhost:8080/meterreadings")).
                then()
                .statusCode(200);
    }


    public static void GetMeterReadingById(String meterReadingId) {
        System.out.println(" meter reading by id ");
        System.out.println(meterReadingId);
        given().contentType(ContentType.JSON)
                .with()
                .pathParam("meterReadingId", meterReadingId)
                .when().get(String.format("http://localhost:8080/meterreadings/{meterReadingId}")).
                then()
                .statusCode(200);
    }


    public static void DeleteMeterReadingById(String MeterId, String MonthName) {
        System.out.println(MeterId);
        System.out.println(MonthName);
        given()
                .contentType(ContentType.JSON)
                .with()
                .when()
                .delete("localhost:8080/meterreadings/meter/1/month/JANUARY1")
                .then()
                .statusCode(204);

    }


    public static void DeleteProfileById(String ProfileId) {
        given()
                .contentType(ContentType.JSON)
                .with()
                .when()
                .delete(String.format("http://localhost:8080/profiles/%s", ProfileId))
                .then().statusCode(204);
    }


}
