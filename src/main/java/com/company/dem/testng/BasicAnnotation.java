package com.company.dem.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase(){
        System.out.println("testCase");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }


    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }


    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }


    @Test(expectedExceptions = RuntimeException.class)
    public void expectExcept(){
        System.out.println("");
    }


    @Test(expectedExceptions = ArithmeticException.class)
    public int expectExcept22(){
        return 1/0;
    }


}
