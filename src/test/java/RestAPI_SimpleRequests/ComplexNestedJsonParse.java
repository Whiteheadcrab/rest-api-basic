package RestAPI_SimpleRequests;

import SetUpCollections.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexNestedJsonParse
{
    public static void main(String[] args)
    {
        JsonPath jsonPath = new JsonPath(payload.ComplexNestedJson());

        //Print number of courses
        //Here size() is a method for checking number of elements in array "courses"
        int numberOfCourses = jsonPath.getInt("courses.size()");
        System.out.println("Number of courses are : " + numberOfCourses);

        //Print Purchase amount
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase amount is : " + purchaseAmount);

        //Print Price amount and title for first element in array
        int firstCoursePriceAmount = jsonPath.getInt("courses[0].price");
        String firstCourseTitle = jsonPath.getString("courses[0].title");
        System.out.println("First Price is : " + firstCoursePriceAmount + " . For Course - " + firstCourseTitle);

        //Print all courses title and their price amount
        for (int i=0;i<numberOfCourses;i++)
        {
            int CoursePriceAmount = jsonPath.getInt("courses["+i+"].price");
            String CourseTitle = jsonPath.getString("courses["+i+"].title");
            System.out.println("Price is : " + CoursePriceAmount + " . For Course - " + CourseTitle);
        }

        //Print number of copies only for element where title is RPA
        for (int i=0;i<numberOfCourses;i++)
        {
            int RPAFoundCount = 0 ;
            String CourseTitle = jsonPath.get("courses[" + i + "].title");
            if (CourseTitle.equalsIgnoreCase("RPA"))
            {
                int RPACopiesAmount = jsonPath.getInt("courses[" + i + "].copies");
                System.out.println("For course " + CourseTitle + " number of copies sold are " + RPACopiesAmount);
                break;
            }
            if (i == numberOfCourses-1 & RPAFoundCount == 0)
            {
                System.out.println("No copies for RPA were found .");
            }
        }

        //Check if sam of sales for all courses equal total income
        int collectedSales = 0 ;
        for (int i=0;i<numberOfCourses;i++)
        {
            int priceOfCourse = jsonPath.getInt("courses["+i+"].price");
            int copiesSoldForCourse = jsonPath.getInt("courses["+i+"].copies");

            collectedSales = collectedSales + priceOfCourse*copiesSoldForCourse;
        }

        Assert.assertEquals(collectedSales,purchaseAmount);
    }
}
