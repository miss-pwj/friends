package com.lcl.model;

import org.springframework.stereotype.Component;

/**
 * @author lcl
 * @date 2019/11/1 21:01
 * @Description
 */

@Component
public class UserImg {
    private int id;
    private String username ;
    private String type;
    private String img;

    public UserImg(String username, String type, String img) {
        this.username = username;
        this.type = type;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public UserImg() {
    }

    @Override
    public String toString() {
        return "UserImg{" +
                "username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
