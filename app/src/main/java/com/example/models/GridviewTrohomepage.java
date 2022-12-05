package com.example.models;

import java.io.Serializable;

public class GridviewTrohomepage implements Serializable {
    private String diachi;
    private String tenphong;
    private String gia;
    private String dientich;
    private int hinhphong;

    public GridviewTrohomepage(String tenphong, int gia) {

    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDientich() {
        return dientich;
    }

    public void setDientich(String dientich) {
        this.dientich = dientich;
    }

    public int getHinhphong() {
        return hinhphong;
    }

    public void setHinhphong(int hinhphong) {
        this.hinhphong = hinhphong;
    }

}
