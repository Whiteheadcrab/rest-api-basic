package RestAPI_SimpleRequests;

import SetUpCollections.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class AddAndChangePlaceID
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
        String addResponse =
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
        System.out.println(addResponse);

        //Initializing jsonPath and creating object for it , response converted from String to Json
        JsonPath jsonPathAdd = new JsonPath(addResponse);

        //Receiving place_id variable form Json file format
        String placeID = jsonPathAdd.getString("place_id");

        System.out.println("place_id: " + placeID);

        //Update address for unit with place_id
        String newAdress = "North Walk , Canada";

        given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body(payload.UpdatePlace(placeID,newAdress))
        .when()
                .put("maps/api/place/update/json")
        .then().log().all()
                .assertThat().statusCode(200)
                .body("msg",equalTo("Address successfully updated"));


        //Get Place
        String getResponse = given().log().all()
                .queryParam("key","qaclick123")
                .queryParam("place_id",placeID)
                .header("Content-Type","application/json")
        .when()
                .get("maps/api/place/get/json")
        .then().log().all()
                .assertThat().statusCode(200)
                .body("address",equalTo(newAdress)).extract().response().asString();

        //Collecting response from get as a JsonPath object
        JsonPath jsonPathGet = reusableMethods.rawToJson(getResponse);
        String actualNewAdress = jsonPathGet.getString("address");
        System.out.println(actualNewAdress);

        //Testng
        Assert.assertEquals(actualNewAdress,newAdress);
        //Junit , Testng
    }
}
