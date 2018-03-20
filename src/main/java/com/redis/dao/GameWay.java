package com.redis.dao;

/*
* 在此处添加所有的玩法
* */

import java.io.Serializable;

public class GameWay implements Serializable {

    private String name;       //某某游戏

    private String address ;  //某某地区合集

    public GameWay() {
    }

    public GameWay(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "GameWay{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
