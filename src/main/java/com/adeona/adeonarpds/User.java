package com.adeona.adeonarpds;

import java.util.List;

public class User {
    String name;
    String desc;
    int id;
    List<String> urls;
    int type;
    public User(String name,String desc,List<String> urls,int type,int id){
        this.name=name;
        this.desc=desc;
        this.urls=urls;
        this.type=type;
        this.id=id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", urls=" + urls +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public List<String> getUrls() {
        return urls;
    }

    public int getType() {
        return type;
    }
    public int getId(){
        return id;
    }
}
