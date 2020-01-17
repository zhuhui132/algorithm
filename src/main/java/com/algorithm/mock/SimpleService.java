package com.algorithm.mock;

public class SimpleService {

    public SimpleService(){

    }



    public void save(User user){
        {
            System.out.println("begin");
        }
        SimpleDao simpleDao = new SimpleDao();
        simpleDao.save(user);
        {
            System.out.println("endding");
        }
    }

}
