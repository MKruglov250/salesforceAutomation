package API.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.PropertyReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class BaseApi {
    Gson gson;
    public RequestSpecification requestSpecification;
    static String token = ApiUtils.getToken();


    public BaseApi() throws IOException {
        gson = new GsonBuilder().create();
        RestAssured.baseURI = PropertyReader.getProperty("ApiUrl");
        requestSpecification = given().contentType(ContentType.JSON)
                .header("ContentType","application/json")
                .header("Authorization", "Bearer " + token)
                .accept(ContentType.JSON)
                .log().all();
    }

    public Response get(String endpoint, int expectedCode){
        return requestSpecification
                .when()
                    .get(RestAssured.baseURI.concat(endpoint))
                .then()
                    .statusCode(expectedCode)
                    .contentType(ContentType.JSON)
                    .extract().response();
    }

    public Response post(String endpoint, int expectedCode, String body){
        return requestSpecification.body(body)
                .when()
                    .post(RestAssured.baseURI.concat(endpoint))
                .then()
                    .statusCode(expectedCode)
                    .extract().response();
    }


    public Response patch(String endpoint, int expectedCode, String body){
        return requestSpecification.body(body)
                .when()
                    .patch(RestAssured.baseURI.concat(endpoint))
                .then()
                    .statusCode(expectedCode)
                    .extract().response();
    }

    public Response delete(String endpoint, int expectedCode){
        return requestSpecification
                .when()
                    .delete(RestAssured.baseURI.concat(endpoint))
                .then()
                    .statusCode(expectedCode)
                    .extract().response();
    }

}
