package com.jd.test;

import com.jayway.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

public class AiocTest {
    @Test
    public void testLogin(){
        RestAssured.baseURI = "http://aioc-jinan.xjoycity.com/sso/?redirectUrl=http://aioc-jinan.xjoycity.com/#/";
        RestAssured.basic("admin","abc321" );
        //ResponseBody rep = RestAssured.post().then().body();
    }
}
