import ResponseModels.Errors;
import ResponseModels.Loginresponse;
import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requests.requests;

public class testlogin {

    static String singleUserEndPoint ="/users/2";
    static String loginEndPoint ="/login";
    static String baseUrl = "https://reqres.in/api";
    static String username ="eve.holt@reqres.in";
    static String password ="cityslicka";


    @Test
    public  void loginsuccess()
    {
        SoftAssert softAssert =new  SoftAssert();
        Response loginres =requests.Loginrequest(username,password);
       Loginresponse loginResponse =loginres.as(Loginresponse.class);
        softAssert.assertEquals(loginres.statusCode(),200,"bla7");
        softAssert.assertEquals(loginResponse.token,"QpwL5tke4Pnpja7X4","bla7");
        softAssert.assertAll();
    }
    @Test
    public static void checkemptymail()
    {
        SoftAssert softAssert =new SoftAssert();

        Response empty2 =requests.Loginrequest("",password);
        //Loginresponse emptymailreponse =empty2.as(Loginresponse.class);
       // Errors error =empty2.as(Errors.class);
        softAssert.assertEquals(empty2.statusCode(),400,"bla7");
       // softAssert.assertEquals(emptymailreponse.token,"QpwL5tke4Pnpja7X4","bla7");
        softAssert.assertAll();

    }
    @Test
    public static void checktoken()
    {
        SoftAssert softAssert =new SoftAssert();
        Loginresponse tokenresponse =requests.Loginrequest(username,password).as(Loginresponse.class);
        //softAssert.assertEquals(tokenresponse.statusCode(),200,"bla7");
        //JsonPath loginjsonpath =tokenresponse.jsonPath();
        softAssert.assertNotNull(tokenresponse.token,"bla7");

    }
    @Test
    public  void missingpass()
    {
        SoftAssert softAssert =new  SoftAssert();
        Response errorres =requests.Loginrequest(username,"");
        Errors errorresponse =errorres.as(Errors.class);
        //softAssert.assertEquals(loginres.statusCode(),200,"bla7");
        softAssert.assertEquals(errorresponse.error,"Missing password","bla7");
        softAssert.assertAll();
    }


}
