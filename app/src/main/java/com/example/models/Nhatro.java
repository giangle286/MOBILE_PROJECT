package com.example.models;

public class Nhatro {
    private int hinhtro;
    private String tentro;
    private String giatro;
    private String dientichtro;
    private String diachi;

    public int getHinhtro() {
        return hinhtro;
    }

    public void setHinhtro(int hinhtro) {
        this.hinhtro = hinhtro;
    }

    public String getTentro() {
        return tentro;
    }

    public void setTentro(String tentro) {
        this.tentro = tentro;
    }

    public String getGiatro() {
        return giatro;
    }

    public void setGiatro(String giatro) {
        this.giatro = giatro;
    }

    public String getDientichtro() {
        return dientichtro;
    }

    public void setDientichtro(String dientichtro) {
        this.dientichtro = dientichtro;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Nhatro(int hinhtro, String tentro, String giatro, String dientichtro, String diachi) {
        this.hinhtro = hinhtro;
        this.tentro = tentro;
        this.giatro = giatro;
        this.dientichtro = dientichtro;
        this.diachi = diachi;
    }
}
