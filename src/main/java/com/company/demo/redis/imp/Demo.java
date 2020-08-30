//package com.company.demo.redis.imp;
//
//import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
//import com.company.demo.redis.JedisClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//
//public class Demo {
//    @Autowired
//    private JedisClient jedisClient;
//
//
//    public void say(){
//        String getData = jedisClient.get("a");
//        if (!StringUtils.isEmpty(getData)){
//            HSFJSONUtils.jsonToList(getData, TbContent.class);
//        }
//    }
//}
