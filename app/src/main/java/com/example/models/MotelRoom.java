package com.example.models;

import java.io.Serializable;

public class MotelRoom implements Serializable {
    public static final int TYPE_TINNOIBATMOTELROOM = 1;
    public static final int TYPE_TINMOINHATMOTELROOM = 2;


    private int TypeMotelRoom;
    private String titleMotelRoom;
    private String nameMotelRoom;
    private String phoneMotelRoom;
    private String addressMotelRoom;
    private String squareMotelRoom;
    private Double nobMotelRoom;
    private String priceMotelRoom;
    private String describeMotelRoom;
    private int resourceImage;

    public MotelRoom(int typeMotelRoom,  String titleMotelRoom,String nameMotelRoom, String phoneMotelRoom, String addressMotelRoom, String squareMotelRoom, Double nobMotelRoom, String priceMotelRoom, String describeMotelRoom, int resourceImage) {
        TypeMotelRoom= typeMotelRoom;

        this.nameMotelRoom = nameMotelRoom;
        this.titleMotelRoom = nameMotelRoom;
        this.phoneMotelRoom = phoneMotelRoom;
        this.addressMotelRoom = addressMotelRoom;
        this.squareMotelRoom= squareMotelRoom;
        this.nobMotelRoom= nobMotelRoom;
        this.priceMotelRoom = priceMotelRoom;
        this.describeMotelRoom = describeMotelRoom;
        this.resourceImage = resourceImage;
    }

    public int getTypeMotelRoom() {
        return TypeMotelRoom;
    }

    public void setTypeMotelRoom(int typeMotelRoom) {
        TypeMotelRoom = typeMotelRoom;
    }
    public String getTitleMotelRoom() {
        return titleMotelRoom;
    }

    public void setTitleMotelRoom(String titleMotelRoom) {
        this.titleMotelRoom = titleMotelRoom;
    }

    public String getNameMotelRoom() {
        return nameMotelRoom;
    }

    public void setNameMotelRoom(String nameMotelRoom) {
        this.nameMotelRoom = nameMotelRoom;
    }

    public String getPhoneMotelRoom() {
        return phoneMotelRoom;
    }

    public void setPhoneMotelRoom(String phoneMotelRoom) {
        this.phoneMotelRoom = phoneMotelRoom;
    }

    public String getAddressMotelRoom() {
        return addressMotelRoom;
    }

    public void setAddressMotelRoom(String addressMotelRoom) {
        this.addressMotelRoom = addressMotelRoom;
    }

    public String getSquareMotelRoom() {
        return squareMotelRoom;
    }

    public void setSquareMotelRooms(String squareMotelRoom) {
        this.squareMotelRoom = squareMotelRoom;
    }

    public Double getNobMotelRoom() {
        return nobMotelRoom;
    }

    public void setNobMotelRoom(Double nobMotelRoom) {
        this.nobMotelRoom = nobMotelRoom;
    }

    public String getPriceMotelRoom() {
        return priceMotelRoom;
    }

    public void setPriceMotelRoom(String priceMotelRoom) {
        this.priceMotelRoom= priceMotelRoom;
    }

    public String getDescribeMotelRoom() {
        return describeMotelRoom;
    }

    public void setDescribeMotelRoom(String describeMotelRoom) {
        this.describeMotelRoom = describeMotelRoom;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }
}