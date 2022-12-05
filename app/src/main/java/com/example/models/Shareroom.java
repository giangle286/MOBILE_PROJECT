package com.example.models;

public class Shareroom {
    private int resourceId;
    private int resourceId1;
    private String tenShareroom;
    private String diachiShareroom;
    private String dientichShareroom;
    private String giaShareroom;

    public Shareroom(int resourceId, int resourceId1, String tenShareroom, String diachiShareroom, String dientichShareroom, String giaShareroom) {
        this.resourceId = resourceId;
        this.resourceId1 = resourceId1;
        this.tenShareroom = tenShareroom;
        this.diachiShareroom = diachiShareroom;
        this.dientichShareroom = dientichShareroom;
        this.giaShareroom = giaShareroom;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId1() {
        return resourceId1;
    }

    public void setResourceId1(int resourceId1) {
        this.resourceId1 = resourceId1;
    }

    public String getTenShareroom() {
        return tenShareroom;
    }

    public void setTenShareroom(String tenShareroom) {
        this.tenShareroom = tenShareroom;
    }

    public String getDiachiShareroom() {
        return diachiShareroom;
    }

    public void setDiachiShareroom(String diachiShareroom) {
        this.diachiShareroom = diachiShareroom;
    }

    public String getDientichShareroom() {
        return dientichShareroom;
    }

    public void setDientichShareroom(String dientichShareroom) {
        this.dientichShareroom = dientichShareroom;
    }

    public String getGiaShareroom() {
        return giaShareroom;
    }

    public void setGiaShareroom(String giaShareroom) {
        this.giaShareroom = giaShareroom;
    }
}
//  <!--   shareroom>-->