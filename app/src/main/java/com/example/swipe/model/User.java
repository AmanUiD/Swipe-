package com.example.swipe.model;

public class User {
    private String Name, Title, Message, Time;
    private int profile, favourite;

    public User(String name, String title, String message, String time, int profile,   int favourite) {
        Name = name;
        Title = title;
        Message = message;
        Time = time;
        this.profile = profile;


        this.favourite = favourite;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }





    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }
}
