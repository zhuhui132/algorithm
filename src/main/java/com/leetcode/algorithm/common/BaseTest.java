//package com.algorithm.common;
//
//import com.google.gson.Gson;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class BaseTest {
//
//
//    // 获取headers
//    public static Map <String, String> getHeader() {
//        String header = IoUtils.getDatafromFile("header");
//        Gson gson = new Gson();
//        Map <String, String> map = new HashMap <String, String>();
//        map = gson.fromJson(header, map.getClass());
//        return map;
//    }
//}
