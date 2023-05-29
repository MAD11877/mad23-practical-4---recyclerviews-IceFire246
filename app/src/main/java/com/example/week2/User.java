package com.example.week2;

public class User {
    public String name;
    public String description;
    public int id;
    public static boolean followed;

    public User(String n, String desc, boolean follow) {
        name = n;
        description = desc;
        followed = follow;
    }
}


