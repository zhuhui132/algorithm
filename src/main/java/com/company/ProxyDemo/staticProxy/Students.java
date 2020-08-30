package com.company.ProxyDemo.staticProxy;

public class Students implements Person {
    private String name;
    public Students(String name){
        this.name = name;
    }
    @Override
    public void giveMoney() {
        System.out.println(name +"60");
    }
}
