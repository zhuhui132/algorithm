package com.demo.mock;

public class MockSimpleDao extends SimpleDao {
    @Override
    public void save(User user){
        System.out.println("MockSimpleDao");
    }
}
