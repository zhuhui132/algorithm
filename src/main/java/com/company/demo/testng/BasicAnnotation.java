package com.company.demo.testng;

import org.junit.Test;
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


    @Test(expected = RuntimeException.class)
    public void expectExcept(){
        System.out.println("");
    }


    @Test(expected = ArithmeticException.class)
    public int expectExcept22(){
        return 1/0;
    }


}
