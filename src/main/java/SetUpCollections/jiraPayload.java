package SetUpCollections;

public class jiraPayload
{
    public static String AddBug()
    {
        String bodyMessage = "{\n" +
                "    \"fields\": {\n" +
                "       \"project\":\n" +
                "       {\n" +
                "          \"key\": \"SCRUM\"\n" +
                "       },\n" +
                "       \"summary\": \"Java Rest API 1 . Dropdowns are not working . Automation \",\n" +
                "       \"issuetype\": {\n" +
                "          \"name\": \"Bug\"\n" +
                "       }\n" +
                "   }\n" +
                "}";

        return bodyMessage;
    }
}
