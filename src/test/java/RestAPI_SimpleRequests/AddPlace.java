package RestAPI_SimpleRequests;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
//This package is for equalTo function in then part
import static org.hamcrest.Matchers.*;

public class AddPlace
{
    public static void main(String[] args) throws IOException {
        // validate if Add Place API is working as expected

        //given - all input data
        //when - submit The API - resources, http, methods
        //there - validate the response
        // content of the file to String -> content of file could be converted into Byte -> after that convert Byte data into String

        //Set up base URI
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        
        given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body(new String (Files.readAllBytes(Paths.get("E:\\Repositories\\IntelliJ Idea\\RestApi_tutorials\\1\\src\\Templates\\Json\\addPlace.json"))))
        .when()
                .post("maps/api/place/add/json")
        .then().log().all()
                .assertThat().statusCode(200)
                    .body("scope",equalTo("APP"))
                    .header("server",equalTo(
                            "Apache/2.4.52 (Ubuntu)"));
    }
}
