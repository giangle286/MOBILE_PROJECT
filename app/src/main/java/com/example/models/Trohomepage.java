package com.example.models;

public class Trohomepage {
    private int resourceId;
    private String txt_NameHomepage;
    private String txt_giaphongtro;
    private String txt_diachiphongtro;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTxt_NameHomepage() {
        return txt_NameHomepage;
    }

    public void setTxt_NameHomepage(String txt_NameHomepage) {
        this.txt_NameHomepage = txt_NameHomepage;
    }

    public String getTxt_giaphongtro() {
        return txt_giaphongtro;
    }

    public void setTxt_giaphongtro(String txt_giaphongtro) {
        this.txt_giaphongtro = txt_giaphongtro;
    }

    public String getTxt_diachiphongtro() {
        return txt_diachiphongtro;
    }

    public void setTxt_diachiphongtro(String txt_diachiphongtro) {
        this.txt_diachiphongtro = txt_diachiphongtro;
    }

    public Trohomepage(int resourceId, String txt_NameHomepage, String txt_giaphongtro, String txt_diachiphongtro) {
        this.resourceId = resourceId;
        this.txt_NameHomepage = txt_NameHomepage;
        this.txt_giaphongtro = txt_giaphongtro;
        this.txt_diachiphongtro = txt_diachiphongtro;
    }
}
