package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v85.fetch.model.AuthChallengeResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class getAPI {
    @Test
    public void verifyGetApi(){

        SoftAssert softAssert = new SoftAssert();
        Response response= RestAssured
                //pre contition
                .given()
                .header("Content-Type", "application/json")
                //method define
                .when()
                .get("https://restful-booker.herokuapp.com/booking/6")
                .then().log().all()
                .extract().response();
        softAssert.assertEquals(response.getStatusCode(),200);
        softAssert.assertEquals(response.jsonPath().getString("firstname"),"Eric");
        softAssert.assertAll();

    }
}
