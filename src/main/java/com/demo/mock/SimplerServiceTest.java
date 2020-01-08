package com.demo.mock;

import org.junit.Before;
import org.junit.Test;
//CGLib
public class SimplerServiceTest {
    private SimpleDao simpleDao;


    @Before
    public void before(){
        this.simpleDao = new MockSimpleDao();

    }


    @Test
    public void test(){
        SimpleService simpleService = new SimpleService();
        simpleService.save(new User());
    }
}
