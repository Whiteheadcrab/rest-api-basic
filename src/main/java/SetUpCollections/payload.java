package SetUpCollections;

public class payload
{
    public static String AddPlace()
    {
        String bodyMessage = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";

        return bodyMessage;
    }

    public static String UpdatePlace(String place_id,String newAdress)
    {
        String bodyMessage = "{\n" +
                "\"place_id\":\""+place_id+"\",\n" +
                "\"address\":\""+newAdress+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";

        return bodyMessage;
    }

    public static String GetUpdatedPlace(String place_id)
    {
        String bodyMessage = "{\n" +
                "    \"location\": {\n" +
                "        \"latitude\": \"-38.383494\",\n" +
                "        \"longitude\": \"33.427362\"\n" +
                "    },\n" +
                "    \"accuracy\": \"50\",\n" +
                "    \"name\": \"Frontline house\",\n" +
                "    \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "    \"address\": \"70 Summer walk, USA\",\n" +
                "    \"types\": \"shoe park,shop\",\n" +
                "    \"website\": \"http://google.com\",\n" +
                "    \"language\": \"French-IN\"\n" +
                "}";

        return bodyMessage;
    }

    public static String ComplexNestedJson()
    {
        String jsonMessage = "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 1110,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "},\n" +
                "  {\n" +
                "\n" +
                "\"title\": \"Json\",\n" +
                "\n" +
                "\"price\": 20,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}\n";

        return jsonMessage;
    }

    public static String AddBook(String aisle, String isbn)
    {
        String bodyMessage = "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";

        return bodyMessage;
    }

    public static String DeleteBook(String id)
    {
        String bodyMessage = "{\n" +
                " \n" +
                "\"ID\" : \""+id+"\"\n" +
                " \n" +
                "}";

        return bodyMessage;
    }
}
