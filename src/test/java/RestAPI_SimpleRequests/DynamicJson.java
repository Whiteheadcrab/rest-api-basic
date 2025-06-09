package RestAPI_SimpleRequests;

import SetUpCollections.payload;
import SetUpCollections.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DynamicJson
{
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn , String aisle)
    {
        RestAssured.baseURI = "http://216.10.245.166";

        //Now with using this code "("aisle", "646")" will be created new book
        //but with updated value "646" for parameter "aisle"
        //for avoiding duplication without changing body request in SetUpCollections.payload file
        String responseAdd =
        given()
                .header("Content-type","application/json")
                .body(payload.AddBook(isbn, aisle))
        .when()
                .post("/Library/Addbook.php")
        .then()
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath jsonPathAdd = reusableMethods.rawToJson(responseAdd);
        String id = jsonPathAdd.getString("ID");

        System.out.println("Id for added book is - " + id);
    }

    @DataProvider(name="BooksData")
    public Object[][] getData()
    {
        return new Object[][]{{"oufwty","9463"},{"cwatee","4153"},{"ogret","733"}};
    }
}
