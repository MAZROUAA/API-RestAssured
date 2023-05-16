import ResponseModels.Singleuser.Singleuser;
import ResponseModels.listusers.listusersresponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requests.requests;

public class Testsingleuser {
    static String singleUserEndPoint ="/users/2";
    static String loginEndPoint ="/login";
    static String baseUrl = "https://reqres.in/api";
    static String username ="eve.holt@reqres.in";
    static String password ="cityslicka";
    static String usersEndpoint = "/users";
    String token = "";

    @Test(priority = 1)
    public void singleuser()
    {
        SoftAssert softAssert =new SoftAssert();

        softAssert.assertEquals(requests.singluser("2").statusCode(),200,"bla7");


        Response singleUserRes = requests.singluser("2");
        Singleuser singleUserResponse = singleUserRes.as(Singleuser.class);

        softAssert.assertEquals(singleUserResponse.data.id,2,"bla7");

        softAssert.assertEquals(singleUserResponse.support.url,"https://reqres.in/#support-heading","bla7");
        //listusersresponse listuserjsonpath =requests.singluser().as(listusersresponse.class);

      /*  List<Map<String,String>> userlist =listuserjsonpath.getList("data");
        for(int i=0;i<userlist.size();i++)
        {
            softAssert.assertNotNull(userlist.get(i).get("first_name"));
        }*/
        softAssert.assertAll();
    }
}
