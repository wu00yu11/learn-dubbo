package com.learn.dubbo.api.model;

import java.io.Serializable;

/**
 * @author jingjing.zhang
 */
public class User implements Serializable {
    private static final long serialVersionUID = -425202952013274599L;

    private String userName;
    private String userAddr;
    private Integer userAge;

    public User() {
    }

    public User(String userName, String userAddr, Integer userAge) {
        this.userName = userName;
        this.userAddr = userAddr;
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
