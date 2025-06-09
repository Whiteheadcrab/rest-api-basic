package RestAPI_SimpleRequests;

import SetUpCollections.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class AddAndCheckPlaceID
{
    public static void main(String[] args)
    {
        // validate if Add Place API is working as expected

        //given - all input data
        //when - submit The API - resources, http, methods
        //there - validate the response

        //Set up base URI
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //Save response into Strign variable
        String response =
            given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body(payload.AddPlace())
            .when()
                .post("maps/api/place/add/json")
            .then().log().all()
                .assertThat().statusCode(200)
                    .body("scope",equalTo("APP"))
                    .header("server",equalTo(
                            "Apache/2.4.52 (Ubuntu)")).extract().response().asString();

        //Print out response in console
        System.out.println(response);

        //Initializing jsonPath and creating object for it , response converted from String to Json
        JsonPath jsonPath = new JsonPath(response);

        //Receiving place_id variable form Json file format
        String placeID = jsonPath.getString("place_id");

        System.out.println("place_id: " + placeID);
    }
}
