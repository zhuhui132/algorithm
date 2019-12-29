package com.zhuhui.guava.utilites;

import com.google.common.base.Joiner;
import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;

public class JoinerTest {

    private final List<String> stringList = Arrays.asList(
            "com", "jd", "test", "com", "huhui", "guava", "utilites");


    private final List<String> stringListWithValue = Arrays.asList(
            "com", "huhui", "guava", "utilites",null);

    private final String targetFileName = "src/test/com/zhuhui/guava/utilites/abc.txt";

    @Test
    public void testJoinOnjoin(){
        String result = Joiner.on("#").join(stringList);
        System.out.println(result);
//        Assert.assertThat(result,("com.zhuhui.guava.utilites"));
        assertThat(result,equalTo("com#jd#test#com#huhui#guava#utilites"));
    }


    @Test(expected = NullPointerException.class)
    public void testJoinOnjoinWithValue(){
        String result = Joiner.on("#").join(stringListWithValue);
        System.out.println(result);
//        Assert.assertThat(result,("com.zhuhui.guava.utilites"));
        assertThat(result,equalTo("com.zhuhui.guava.utilites"));
    }


    @Test
    public void testJoinOnjoinWithValue2(){
        String result = Joiner.on("#").skipNulls().join(stringListWithValue);
        System.out.println(result);
//        Assert.assertThat(result,("com.zhuhui.guava.utilites"));
        assertThat(result,equalTo("com#huhui#guava#utilites"));
    }


    @Test
    public void testJoinOnjoinWithValue_User_DefaltValue(){
        String result = Joiner.on("#").useForNull("DefaltValue").join(stringListWithValue);
        System.out.println(result);
//        Assert.assertThat(result,("com.zhuhui.guava.utilites"));
        assertThat(result,equalTo("com#huhui#guava#utilites"));
    }


    @Test
    public void testJoin_ToStringBufer() throws IOException {
        final StringBuffer stringBuffer = new StringBuffer();
        StringBuffer result = Joiner.on("#").useForNull("DefaltValue").appendTo(stringBuffer,stringListWithValue);
        assertThat(result,sameInstance(stringBuffer));
        assertThat(result.toString(),equalTo("com#huhui#guava#utilites#DefaltValue"));
//        Assert.assertThat(result,("com.zhuhui.guava.utilites"));
        assertThat(stringBuffer.toString(),equalTo("com#huhui#guava#utilites#DefaltValue"));
    }

    @Test
    public void testJoin_ToStringBuferToWrite() throws IOException {


        try {
            FileWriter fileWriter = new FileWriter(new File(targetFileName));
            Joiner.on("#").useForNull("DefaltValue").appendTo(fileWriter,stringListWithValue);
            assertThat(Files.isFile().test(new File(targetFileName)),equalTo(true));
        }
        catch (IOException e){
            fail("apped to the write oocc fial");
            e.printStackTrace();
        }
        final StringBuffer stringBuffer = new StringBuffer();
        StringBuffer result = Joiner.on("#").useForNull("DefaltValue").appendTo(stringBuffer,stringListWithValue);
        assertThat(result,sameInstance(stringBuffer));
        assertThat(result.toString(),equalTo("com#huhui#guava#utilites#DefaltValue"));
//        Assert.assertThat(result,("com.zhuhui.guava.utilites"));
        assertThat(stringBuffer.toString(),equalTo("com#huhui#guava#utilites#DefaltValue"));
    }


    @Test
    public void testJoinByStream(){
        String result = stringListWithValue.stream()
                .filter(item -> item != null && !item.isEmpty())
                .collect(Collectors.joining("#"));
        assertThat(result.toString(),equalTo("com#huhui#guava#utilites#DefaltValue"));


    }
}
