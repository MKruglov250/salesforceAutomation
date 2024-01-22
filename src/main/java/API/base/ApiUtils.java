package API.base;

import dto.ApiUser;
import dto.ApiUserBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.PropertyReader;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    private static ApiUser user;

    static {
        try {
            user = ApiUserBuilder.getApiUser();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getToken() throws FileNotFoundException {
        String endpoint = PropertyReader.getLoginUrl() + "services/oauth2/token";
        RequestSpecification requestSpecification = given().contentType("multipart/form-data")
                .multiPart("username",user.getUsername())
                .multiPart("password",user.getPassword())
                .multiPart("grant_type",user.getGrant_type())
                .multiPart("client_id",user.getClient_id())
                .multiPart("client_secret",user.getClient_secret())
                .accept(ContentType.JSON)
                .log().all();
        Response response = requestSpecification.post(endpoint).
                then()
                    .statusCode(200)
                    .extract().response();
         return response.body().path("access_token");
    }
}
