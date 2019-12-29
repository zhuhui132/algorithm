package com.zhuhui.guava.utilites;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class JoinerTest {

    private final List<String> stringList = Arrays.asList(
            "com", "jd", "test", "com", "huhui", "guava", "utilites");


    private final List<String> stringListWithValue = Arrays.asList(
            "com", "huhui", "guava", "utilites");



    @Test
    public void testJoinOnjoin(){
        String result = Joiner.on("#").join(stringListWithValue);
        System.out.println(result);
//        Assert.assertThat(result,("com.zhuhui.guava.utilites"));
        assertThat(result,equalTo("com.zhuhui.guava.utilites"));
    }
}
