package com.company.demo.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuitConfig {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforeSuit");
    }



    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }
}
