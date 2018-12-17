package com.tulun.service;

import com.tulun.bean.WebUser;

public interface UserService {
    void addUser(WebUser user);
    void removeUser(WebUser user);
    void modifyUser(WebUser user);
    WebUser queryUserByName(String name);
}
