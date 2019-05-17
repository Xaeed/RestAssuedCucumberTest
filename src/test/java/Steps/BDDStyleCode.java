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
        System.out.println(profileId);
        System.out.println("ProfileId");
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

    public static void GetAllProfileFractions(String profileName) {
        given().contentType(ContentType.JSON)
                .when()
                .pathParam("profileName", profileName)
                .when().get("http://localhost:8080/profiles/{profileName}/fractions")
                .then()
                .statusCode(200);
    }

    public static void FractionGetbyId(String fractionId) {
        System.out.println(fractionId);
        given().
                contentType(ContentType.JSON)
                .with()
                .queryParam("fractionId", fractionId)
                .when()
                .get("http://localhost:8080/profiles/fractions/5")
                .then()
                .statusCode(200);
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
