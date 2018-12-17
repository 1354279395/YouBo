package com.tulun.bean;

import java.io.Serializable;

public class WebUser implements Serializable {
    private Integer id;

    private String username;

    private String userpwd;

    private String identity;

    public WebUser(){

    }
    public WebUser(String username, String userpwd, String identity) {
        this.username=username;
        this.userpwd=userpwd;
        this.identity=identity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    @Override
    public String toString() {
        return "WebUser{" +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}