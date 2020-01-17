package com.algorithm.service;

import com.algorithm.common.User;
import com.algorithm.dao.UserDao;

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
