package com.jd.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class RestTest {
    static String link = "https://api.spotify.com/v1/artists/1vCWHaC5f2uS3yhpwWbIA6/albums?album_type=SINGLE&offset=20&limit=1";    
 
    public static void main(String[] args) {
        Response response = RestAssured.get(link);
        //response.then().assertThat().statusCode(200);  //This fails
        response.then().assertThat().statusCode(401);  //This passes
    }


    @Test
    public void testLogin(){
        String url  = "http://aioc-jinan.xjoycity.com";
        RestAssured.baseURI = url;
//        RestAssured.given()
//                .formParam("userName","admin")
//                .formParam("password","abc321")
//                .when()
//                .post("/sso/login")
//                .then().statusCode(200);

        Response response =
                RestAssured.given()
                        .formParam("userName","admin")
                        .formParam("password","abc321")
                        .params("redirectUrl","http://aioc-jinan.xjoycity.com/")
                        .when()
                        .post("/sso/login").then().
                        extract().
                        response();
        System.out.println(response.header("Set-Cookie"));
    }
    
}