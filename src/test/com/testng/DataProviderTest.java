package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @Test(dataProvider = "user")
    public void testFaceLogin(String name,String passWd,String exceptStr){
        System.out.println(name+passWd+exceptStr);


    }

    @DataProvider(name = "user")
    public Object[][] user(){
        return new Object[][]{
                { "", "", "账号不能为空" },
                { "admin"," " ,"密码不能为空" },
                { " ", "a123456","账号不能为空" },
                { "ad ", "123456","账号“ad”不存在" },
                { "admin","12345" ,"密码错误" },
        };
    }
}