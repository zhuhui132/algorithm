package com.company.ProxyDemo.staticProxy;



public class StaticProxyTest {
    public static void main(String[] args) {
        //被代理的学生张三，他的班费上交有代理对象monitor（班长）完成
        Person zhangsan = new Students("张三");

        Person monitoe = new StudentsProxy(zhangsan);
        //班长代理上交班费
        monitoe.giveMoney();
    }



}
