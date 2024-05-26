package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.*;

public class RestAssuredTest {

    RequestSpecification requestSpecification = RestAssured.given()
            .baseUri("https://dummy.restapiexample.com")
            .contentType(ContentType.JSON);


    @BeforeClass
    public void setUp(){
        RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL).enablePrettyPrinting(true));
    }

    @Test
    public void myRestTest(){
        RestAssured.baseURI = "https://dummy.restapiexample.com";
        String apiEndpoint = "/api/v1/employees";
        Response response = RestAssured.given()
                .when().get(apiEndpoint).andReturn();
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.getBody().jsonPath().get("status").toString());
        System.out.println(RestAssured.given().when().get(apiEndpoint).then().extract().contentType());
        String body = response.getBody().prettyPrint();
    }

    @Test
    public void myCreateEmployee() throws JsonProcessingException {
        RestAssured.baseURI="https://dummy.restapiexample.com";
        String apiEndPoint = "/api/v1/create";
        String payload = "{\"name\":\"Sourabh\",\"salary\":\"123\",\"age\":\"23\"}";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .with()
                .body(payload)
                .when()
                .post(apiEndPoint)
                .then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(),200);
        ObjectMapper objectMapper = new ObjectMapper();
            JsonNode tree = objectMapper.readTree(payload);

    }

    @Test
    public void myRequestSpecification(){
        String payload = "{\"name\":\"Sourabh\",\"salary\":\"123\"}";
        String apiEndpoint = "/api/v1/create";
        Response response = requestSpecification.with().body(payload).when().post(apiEndpoint).then().extract().response();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void getDataFromApi(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://dummy.restapiexample.com");
        requestSpecification.log().all();
        Response response = requestSpecification.when().get("/api/v1/employees").then().extract().response();
        String headervalue = requestSpecification.when().get("/api/v1/employees").then().extract().header("Content-Type");
        System.out.println(headervalue);
        Headers headers = response.getHeaders();
        for (Header header:headers){
            System.out.println(header.getName()+" "+header.toString());
        }
    }
}
