package com.tulun.web.controller;

import com.tulun.bean.WebUser;
import com.tulun.service.UserService;
import com.tulun.service.serviceimpl.UserServiceImpl;

public class Usercontroller {
    private UserService user;

    public Usercontroller(){
        user = new UserServiceImpl();
    }

    public void add(WebUser a) {
        user.addUser(a);
    }

    public WebUser query(String name){
        return user.queryUserByName(name);
    }

    public void remove(WebUser a){
        user.removeUser(a);
    }

    public void modify(WebUser a){
        user.modifyUser(a);
    }
}
