package com.demo.mock;

public class SimpleDao {
    public void save(User user){
        throw new RuntimeException("数据库连不上");
    }
}
