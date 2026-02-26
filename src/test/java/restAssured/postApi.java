package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import org.hamcrest.Matchers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class postApi {

    @Test
    public void postTest() {
        SoftAssert softAssert = new SoftAssert();

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
        JSONObject js = new JSONObject();
        JSONObject bd = new JSONObject();
        js.put("firstname", "Tanush");
        js.put("Lastname", "Puri");
        js.put("totalprice", "121");
        js.put("depositpaid", true);
        js.put("bookingdates", bd);
        js.put("additionalneeds", "Breakfast");

        bd.put("checkin", "2018-01-01");
        bd.put("checkout", "2018-01-02");

        RestAssured
                //pre contition
                .given()
                .header("Content-Type", "application/json")
                .body(js.toJSONString())
                //method define
                .when()
                .post()
                .then().log().all()
                .body("bookingid", Matchers.notNullValue(),
                        "booking.firstname", Matchers.equalTo("Tanush"),
                        "booking.Lastname", Matchers.equalTo("Puri"));

    }
}