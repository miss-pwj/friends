package com.lcl.model;

import java.sql.Clob;

/**
 * @author lcl
 * @date 2019/11/9 15:33
 * @Description
 */
public class UserIntroduce {
    private String username;    //用户名
    private String introduce;     //存储发言

    public UserIntroduce(String username, String introduce) {
        this.username = username;
        this.introduce = introduce;
    }
public UserIntroduce() {

    }

    public UserIntroduce(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "UserIntroduce{" +
                "username='" + username + '\'' +
                ", introduce=" + introduce +
                '}';
    }
}
