package RestAPI_SimpleRequests;

import SetUpCollections.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation
{
    @Test
    public void sumOfCourses()
    {
        //Json Path
        JsonPath jsonPath = new JsonPath(payload.ComplexNestedJson());
        //Here size() is a method for checking number of elements in array "courses"
        int numberOfCourses = jsonPath.getInt("courses.size()");
        //Save Purchase amount
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");

        //Check if sam of sales for all courses equal total income
        int collectedSales = 0 ;
        for (int i=0;i<numberOfCourses;i++)
        {
            int priceOfCourse = jsonPath.getInt("courses["+i+"].price");
            int copiesSoldForCourse = jsonPath.getInt("courses["+i+"].copies");
            int sumPerCourse = priceOfCourse*copiesSoldForCourse;
            System.out.println("Total amount is " + sumPerCourse + " for course number " +(i+1));
            collectedSales = collectedSales + sumPerCourse;
        }

        Assert.assertEquals(collectedSales,purchaseAmount);
    }
}
