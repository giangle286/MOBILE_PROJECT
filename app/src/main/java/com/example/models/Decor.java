package com.example.models;

import java.io.Serializable;

public class Decor implements Serializable {
    private int resourceImage;
    private String nameDecor;
    private String userDecor;
    private String timeDecor;

    public Decor(int resourceImage, String nameDecor, String userDecor, String timeDecor) {
        this.resourceImage = resourceImage;
        this.nameDecor = nameDecor;
        this.userDecor = userDecor;
        this.timeDecor = timeDecor;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getNameDecor() {
        return nameDecor;
    }

    public void setNameDecor(String nameDecor) {
        this.nameDecor = nameDecor;
    }

    public String getUserDecor() {
        return userDecor;
    }

    public void setUserDecor(String userDecor) {
        this.userDecor = userDecor;
    }

    public String getTimeDecor() {
        return timeDecor;
    }

    public void setTimeDecor(String timeDecor) {
        this.timeDecor = timeDecor;
    }
}
