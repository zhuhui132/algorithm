package com.company.ProxyDemo.staticProxy;



public class StudentsProxy implements Person {
    Students stu;


    public StudentsProxy(Person stu){
        if(stu.getClass() == Students.class) {
            this.stu = (Students)stu;
        }
    }
    //代理上交班费，调用被代理学生的上交班费行为
    @Override
    public void giveMoney() {
        stu.giveMoney();
    }
}
