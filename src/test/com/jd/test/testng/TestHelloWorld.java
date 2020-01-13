package com.jd.test.testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestHelloWorld {

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass");
    }



    @Test
    public void testEmailGenerator() {

        RandomEmailGenerator obj = new RandomEmailGenerator();
        String email = obj.generate();

        Assert.assertNotNull(email);
        Assert.assertEquals(email, "feedback@yiibai.com");

    }

}
//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/testng/hello-world-example.html#article-start

