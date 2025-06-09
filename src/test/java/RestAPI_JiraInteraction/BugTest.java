package RestAPI_JiraInteraction;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import SetUpCollections.*;
import io.restassured.path.json.JsonPath;

import java.io.File;

public class BugTest
{
        public static void main (String[] args)
        {
            RestAssured.baseURI = "https://mykytabieliaiev.atlassian.net";

            String encodedToken = "Basic YmllbGlhaWV2Lm15a3l0YUBnbWFpbC5jb206QVRBVFQzeEZmR0YwWkFnek5jU2VIaEJwcC1iajhIbHJ5ZGR3WEI0RUtBMDY5YVBhbFI3YzlNRDM1LVNZVmpFQnp6aUxmM1B1a3lmTzZWbGJaSWs3MUM3ZUZMMFM5eEVPMWtjUTZjeFl0WlkyS0NsaS0walZPSGlGUTBldXJRWU54Z0lWcTZrUnZMa040Ry1HQmNnb0lDcVJYcGNmck9hQ3IxOFprVDBqODY3S3BESlhNMm1tQm0wPTYxRDcwREJD";

            String addBugResponse =

            //Create bug
            given()
                    .header("Content-Type","application/json")
                    .header("Authorization",encodedToken)
                    .body(jiraPayload.AddBug())
                    .log().all()
                    .post("rest/api/3/issue")
            .then().log().all()
                    .assertThat().statusCode(201)
                    .extract().response().asString();

            JsonPath js = reusableMethods.rawToJson(addBugResponse);

            String idCreatedBug = js.getString("id");

            System.out.println("Id for created bug item is " + idCreatedBug);

            //Adding screenshout which will be used as an attachemnts
            File bodyAttachemnt = new File("E:\\Repositories\\IntelliJ Idea\\RestApi_tutorials\\1\\src\\main\\java\\pngFiles\\2025-05-18 12_18_45-Window.png");

            given()
                    .pathParam("key",idCreatedBug)
                    .header("X-Atlassian-Token","no-check")
                    .header("Authorization",encodedToken)
                    .multiPart("file", bodyAttachemnt)
                    .log().all()
                    .post("rest/api/3/issue/{key}/attachments")
            .then().log().all()
                    .assertThat().statusCode(200);
        }
}
