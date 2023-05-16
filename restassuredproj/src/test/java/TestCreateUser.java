import ResponseModels.Createuserresponse;
import ResponseModels.Loginresponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requests.requests;

public class TestCreateUser {
    static String singleUserEndPoint ="/users/2";
    static String loginEndPoint ="/login";
    static String baseUrl = "https://reqres.in/api";
    static String username ="eve.holt@reqres.in";
    static String password ="cityslicka";
    @Test
    public  void createusertest()
    {
        SoftAssert softAssert =new  SoftAssert();
        Response createuserres = requests.createuser("morpheus","leader");
        Createuserresponse createuserresponse =createuserres.as(Createuserresponse.class);
        softAssert.assertEquals(createuserres.statusCode(),201,"bla7");
        softAssert.assertEquals(createuserresponse.name,"morpheus","bla7");
        softAssert.assertAll();
    }
}
