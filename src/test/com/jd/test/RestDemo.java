package com.jd.test;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestDemo {
    @Before
    public void setUP() {
        //指定 URL 和端口号
        RestAssured.baseURI = "http://api.douban.com/v2/book";
        RestAssured.port = 80;
    }

    @Test
    public void testGETBook() {
        get("/1220562").then().body("title", equalTo("满月之夜白鲸现"));
    }

}