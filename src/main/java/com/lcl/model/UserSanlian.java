package com.lcl.model;

/**
 * @author lcl
 * @date 2019/11/18 9:51
 * @Description
 */
public class UserSanlian {
    private long id;        //用户id
    private String username;    //姓名
    private String type;        //关注、收藏、点赞
    private int num;

    public UserSanlian(long id, String username, String type, int num) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.num = num;
    }

    public UserSanlian() {
    }

    @Override
    public String toString() {
        return "UserSanlian{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", num=" + num +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
