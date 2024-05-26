package restassured;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Payment service verification")
public class SimpleTest {

    @Story("As a admin user, I want to get the name of customers")
    @Test(description = "Simple get call")
    public void simpleTest(){
        RestAssured.baseURI = "https://abc.com";
        Response response = RestAssured.given().header("Content-Type","application/json")
                .when()
                .get("/name").then().extract().response();

        apiResponse(response);

    }

    @Step("Verify api response is success")
    public void apiResponse(Response response){
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
