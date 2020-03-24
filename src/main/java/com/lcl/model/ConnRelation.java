package com.lcl.model;

/**
 * @author lcl
 * @date 2019/11/18 20:13
 * @Description
 */
public class ConnRelation {
    private int id;
    private String connecter;
    private String connected;

    public ConnRelation(int id, String connecter, String connected) {
        this.id = id;
        this.connecter = connecter;
        this.connected = connected;
    }

    public ConnRelation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConnecter() {
        return connecter;
    }

    public void setConnecter(String connecter) {
        this.connecter = connecter;
    }

    public String getConnected() {
        return connected;
    }

    public void setConnected(String connected) {
        this.connected = connected;
    }
}
