package com.lcl.model;

/**
 * @author lcl
 * @date 2019/10/20 23:04
 * @Description
 */
public class User {

    private Integer id;          //用户id
    private String username;    //用户名
    private String sex;         //性别
    private String sexual;      //性取向

    private String marryStatus; //婚姻状态
    private String password;    //密码
    private String confpassword;    //确认密码
    private String email;       //邮箱

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public User(Integer id, String username, String sex, String sexual, String marryStatus, String password, String confpassword, String email, int collection, String phone) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.sexual = sexual;
        this.marryStatus = marryStatus;
        this.password = password;
        this.confpassword = confpassword;
        this.email = email;
        this.collection = collection;
        this.phone = phone;
    }

    private int collection;     //被收藏数


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;       //手机号

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSexual() {
        return sexual;
    }

    public void setSexual(String sexual) {
        this.sexual = sexual;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfpassword() {
        return confpassword;
    }

    public void setConfpassword(String confpassword) {
        this.confpassword = confpassword;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public User(String username, String sex, String sexual, String marryStatus, String password, String confpassword, String email) {
        this.username = username;
        this.sex = sex;
        this.sexual = sexual;
        this.marryStatus = marryStatus;
        this.password = password;
        this.confpassword = confpassword;
        this.email = email;
    }
    public User(String username, String sex, String sexual, String marryStatus, String password, String email) {
        this.username = username;
        this.sex = sex;
        this.sexual = sexual;
        this.marryStatus = marryStatus;
        this.password = password;
        this.email = email;
    }
    public User() {

    }

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }


    public static void main(String[] args){
        System.out.println(0==0.0);
    }
}

