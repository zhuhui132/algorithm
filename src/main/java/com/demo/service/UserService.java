package com.demo.service;

import com.demo.common.User;
import com.demo.dao.UserDao;

public class UserService {
    private UserDao dao;

    public UserService(UserDao dao){
        this.dao = dao;
    }
    public int queryUsercount(){
        return dao.getCount();
    }


    public int save(User user){
        return dao.inserUser(user);
    }
}
