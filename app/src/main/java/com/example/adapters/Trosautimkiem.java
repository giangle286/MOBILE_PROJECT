package com.example.adapters;

public class Trosautimkiem {


    private String TenSautimkiem;
    private String GiaSautimkiem;
    private String DientichSautimkiem;
    private String DiachiSautimkiem;
    private int ImageSautimkiem;

    public String getTenSautimkiem() {
        return TenSautimkiem;
    }

    public void setTenSautimkiem(String tenSautimkiem) {
        TenSautimkiem = tenSautimkiem;
    }

    public String getGiaSautimkiem() {
        return GiaSautimkiem;
    }

    public void setGiaSautimkiem(String giaSautimkiem) {
        GiaSautimkiem = giaSautimkiem;
    }

    public String getDientichSautimkiem() {
        return DientichSautimkiem;
    }

    public void setDientichSautimkiem(String dientichSautimkiem) {
        DientichSautimkiem = dientichSautimkiem;
    }

    public String getDiachiSautimkiem() {
        return DiachiSautimkiem;
    }

    public void setDiachiSautimkiem(String diachiSautimkiem) {
        DiachiSautimkiem = diachiSautimkiem;
    }

    public int getImageSautimkiem() {
        return ImageSautimkiem;
    }

    public void setImageSautimkiem(int imageSautimkiem) {
        ImageSautimkiem = imageSautimkiem;
    }

    public Trosautimkiem(String tenSautimkiem, String giaSautimkiem, String dientichSautimkiem, String diachiSautimkiem, int imageSautimkiem) {
        TenSautimkiem = tenSautimkiem;
        GiaSautimkiem = giaSautimkiem;
        DientichSautimkiem = dientichSautimkiem;
        DiachiSautimkiem = diachiSautimkiem;
        ImageSautimkiem = imageSautimkiem;
    }
}