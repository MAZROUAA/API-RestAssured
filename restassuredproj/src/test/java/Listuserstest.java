import ResponseModels.Loginresponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ResponseModels.listusers.listusersresponse;
import ResponseModels.listusers.Datum;
import requests.requests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Listuserstest {
    static String singleUserEndPoint ="/users/2";
    static String loginEndPoint ="/login";
    static String baseUrl = "https://reqres.in/api";
    static String username ="eve.holt@reqres.in";
    static String password ="cityslicka";
    static String usersEndpoint = "/users";
    String token = "";



    @BeforeClass
    public void loginsucc()
    {
        Loginresponse loginresponse=requests.Loginrequest(username,password).as(Loginresponse.class);
        token= loginresponse.token;
    }
    @Test (priority = 1)
                public void listuserssuc()
    {
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization",token);

        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("page","");

        SoftAssert softAssert =new SoftAssert();

        softAssert.assertEquals(requests.listuserssuc(headers,queryParams).statusCode(),200,"bla7");
        //softAssert.assertEquals(requests.listuserssuc().jsonPath().getString("page"),"2","bla7");
        //softAssert.assertEquals(requests.listuserssuc().jsonPath().getString("data[0].id"),requests.listuserssuc().jsonPath().getString("per_page+1"),"bla7");
        //listusersresponse listuserjsonpath =requests.listuserssuc().as(listusersresponse.class);

      /*  List<Map<String,String>> userlist =listuserjsonpath.getList("data");
        for(int i=0;i<userlist.size();i++)
        {
            softAssert.assertNotNull(userlist.get(i).get("first_name"));
        }*/
        softAssert.assertAll();
    }

}
