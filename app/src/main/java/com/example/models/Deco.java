package com.example.models;

public class Deco {
    private int resourceId;
    private String nameDeco;
    private String userDeco;
    private String timeDeco;

    public Deco(int resourceId, String nameDeco, String userDeco, String timeDeco) {
        this.resourceId = resourceId;
        this.nameDeco = nameDeco;
        this.userDeco = userDeco;
        this.timeDeco = timeDeco;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getNameDeco() {
        return nameDeco;
    }

    public void setNameDeco(String nameDeco) {
        this.nameDeco = nameDeco;
    }

    public String getUserDeco() {
        return userDeco;
    }

    public void setUserDeco(String userDeco) {
        this.userDeco = userDeco;
    }

    public String getTimeDeco() {
        return timeDeco;
    }

    public void setTimeDeco(String timeDeco) {
        this.timeDeco = timeDeco;
    }
}
