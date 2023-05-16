package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Main {
    public static void main(String[] args) {
       // Response singleuserresponse =RestAssured.given().log().all().get("https://reqres.in/api/users/2");
         //       System.out.println(singleuserresponse.statusCode());
           //     singleuserresponse.prettyPrint();

       Response loginresponse =RestAssured.given().log().all().contentType("application/json").body("{\n" +
               "    \"email\": \"eve.holt@reqres.in\",\n" +
               "    \"password\": \"cityslicka\"\n" +
               "}").post("https://reqres.in/api/login");
       System.out.println(loginresponse.statusCode());
        String name=loginresponse.path("token");
        System.out.println(name);
        loginresponse.prettyPrint();

        JsonPath loginjasonpath =loginresponse.jsonPath();
        String token = loginjasonpath.getString("token");
        System.out.println(token);



    }
}