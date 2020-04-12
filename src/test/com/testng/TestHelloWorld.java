package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHelloWorld {

    @Test
    public void testRadomEmal(){
        RandomEmailGenerator obj = new RandomEmailGenerator();

        String email = obj.generate();

        Assert.assertNotNull(email);
        Assert.assertEquals(email,"feedback@yiibai.com");

    }
}
