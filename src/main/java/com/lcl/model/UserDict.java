package com.lcl.model;

/**
 * @author lcl
 * @date 2019/11/3 10:24
 * @Description
 */
public class UserDict {

    private int id;
    private String type;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UserDict(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public UserDict() {
    }

    @Override
    public String toString() {
        return "UserDict{" +
                "id=" + this.getId() +
                ", type='" + this.getType() + '\'' +
                ", value='" + this.getValue() + '\'' +
                '}';
    }
}
