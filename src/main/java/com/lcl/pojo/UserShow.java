package com.lcl.pojo;

import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * @author lcl
 * @date 2019/11/15 16:47
 * @Description
 */

//接收主界面返回数据
public class UserShow {
    private long id;

    private String username;

    private String img;

    public UserShow(long id,String username, String img) {
        this.id = id;
        this.username = username;
        this.img = img;
    }

    public UserShow() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserShow{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
