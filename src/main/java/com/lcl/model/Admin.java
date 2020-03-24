package com.lcl.model;

/**
 * @author lcl
 * @date 2019/11/15 12:44
 * @Description
 */
//管理员
public class Admin {
    private int id;
    private String admin;
    private String password;

    public Admin(int id, String admin, String password) {
        this.id = id;
        this.admin = admin;
        this.password = password;
    }

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", admin='" + admin + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
