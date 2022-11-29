package com.example.moroapplication.models;

public class Deco {
//    thuộc tính của dối tượng đc định nghĩa trong class
    int ThumbDeco;
    String NameDeco;
    String UserDeco;
    String TimeDeco;

    public Deco(int thumbDeco, String nameDeco, String userDeco, String timeDeco) {
        ThumbDeco = thumbDeco;
        NameDeco = nameDeco;
        UserDeco = userDeco;
        TimeDeco = timeDeco;
    }

    public int getThumbDeco() {
        return ThumbDeco;
    }

    public void setThumbDeco(int thumbDeco) {
        ThumbDeco = thumbDeco;
    }

    public String getNameDeco() {
        return NameDeco;
    }

    public void setNameDeco(String nameDeco) {
        NameDeco = nameDeco;
    }

    public String getUserDeco() {
        return UserDeco;
    }

    public void setUserDeco(String userDeco) {
        UserDeco = userDeco;
    }

    public String getTimeDeco() {
        return TimeDeco;
    }

    public void setTimeDeco(String timeDeco) {
        TimeDeco = timeDeco;
    }
}
