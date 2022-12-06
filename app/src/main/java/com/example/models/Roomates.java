package com.example.models;

import java.io.Serializable;

public class Roomates implements Serializable {
    public static final int TYPE_TINNOIBAT = 1;
    public static final int TYPE_TINMOINHAT = 2;


    private int TypeRoomates;
    private String nameRoomates;
    private String titleRoomates;
    private String phoneRoomates;
    private String addressRoomates;
    private String squareRoomates;
    private Double nobRoomates;
    private String genderRoomates;
    private String describeRoomates;
    private int resourceImage;

    public Roomates(int typeRoomates, String titleRoomates,String nameRoomates, String phoneRoomates, String addressRoomates, String squareRoomates, Double nobRoomates, String genderRoomates, String describeRoomates, int resourceImage) {
        TypeRoomates = typeRoomates;
        this.titleRoomates= titleRoomates;
        this.nameRoomates = nameRoomates;
        this.phoneRoomates = phoneRoomates;
        this.addressRoomates = addressRoomates;
        this.squareRoomates = squareRoomates;
        this.nobRoomates = nobRoomates;
        this.genderRoomates = genderRoomates;
        this.describeRoomates = describeRoomates;
        this.resourceImage = resourceImage;
    }

    public int getTypeRoomates() {
        return TypeRoomates;
    }

    public void setTypeRoomates(int typeRoomates) {
        TypeRoomates = typeRoomates;
    }
    public String getTitleRoomates() {
        return titleRoomates;
    }

    public void setTitleRoomates(String titleRoomates) {
        this.titleRoomates = titleRoomates;
    }

    public String getNameRoomates() {
        return nameRoomates;
    }

    public void setNameRoomates(String nameRoomates) {
        this.nameRoomates = nameRoomates;
    }

    public String getPhoneRoomates() {
        return phoneRoomates;
    }

    public void setPhoneRoomates(String phoneRoomates) {
        this.phoneRoomates = phoneRoomates;
    }

    public String getAddressRoomates() {
        return addressRoomates;
    }

    public void setAddressRoomates(String addressRoomates) {
        this.addressRoomates = addressRoomates;
    }

    public String getSquareRoomates() {
        return squareRoomates;
    }

    public void setSquareRoomates(String squareRoomates) {
        this.squareRoomates = squareRoomates;
    }

    public Double getNobRoomates() {
        return nobRoomates;
    }

    public void setNobRoomates(Double nobRoomates) {
        this.nobRoomates = nobRoomates;
    }

    public String getGenderRoomates() {
        return genderRoomates;
    }

    public void setGenderRoomates(String genderRoomates) {
        this.genderRoomates = genderRoomates;
    }

    public String getDescribeRoomates() {
        return describeRoomates;
    }

    public void setDescribeRoomates(String describeRoomates) {
        this.describeRoomates = describeRoomates;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }
}