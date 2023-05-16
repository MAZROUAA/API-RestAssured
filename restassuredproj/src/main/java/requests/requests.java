package requests;

import Helpers.Helpers;
import Requestmodels.Createuserrequest;
import Requestmodels.Loginrequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import ResponseModels.Loginresponse;


import java.util.Map;

public class requests {
    static String singleUserEndPoint ="/users/2";
    static String loginEndPoint ="/login";
    static String baseUrl = "https://reqres.in/api";
    static String username ="eve.holt@reqres.in";
    static String password ="cityslicka";
    static String usersEndpoint = "/users";
    static String token = "";
   /* public  static Response Loginrequest(String username, String password)
    {
        Response loginResponse = RestAssured.given().log().all().contentType("application/json")
                .body("{\n" +
                "    \"email\": \""+username+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}").post(baseUrl+loginEndPoint);


        return loginResponse;
    }*/
    public static Response listuserssuc(Map<String,String> headers, Map<String,String> queryParams)
    {
        Response listuserresponse = RestAssured.given().log().all().headers(headers)
                .queryParams(queryParams).get(baseUrl+usersEndpoint);
        return listuserresponse;

    }
    public static Response singluser(String idNum)
    {
        Response singleuserresponse = RestAssured.given().log().all()./*pathParam("userId",idNum)*/header("Authorization",token)
                .get(baseUrl+usersEndpoint+"/"+idNum);
        return singleuserresponse;

    }
    public  static Response Loginrequest(String username, String password)
    {
        Loginrequest loginrequest =new Loginrequest();
        loginrequest.email=username;
        loginrequest.password=password;

        Response loginResponse = RestAssured.given().log().all().contentType("application/json")
                .body(Helpers.getObjectasstring(loginrequest)).post(baseUrl+loginEndPoint);


        return loginResponse;
    }
    public static Response createuser(String name,String job)
    {
        Createuserrequest createuserrequest =new Createuserrequest();
        createuserrequest.name=name;
        createuserrequest.job=job;

        Response createuserresponse = RestAssured.given().log().all()
                .contentType("application/json")
                .body(Helpers.getObjectasstring(createuserrequest)).post(baseUrl+usersEndpoint);
        return createuserresponse;

    }
}
