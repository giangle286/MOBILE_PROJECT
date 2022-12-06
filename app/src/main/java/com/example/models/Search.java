package com.example.models;

import java.io.Serializable;

public class Search implements Serializable {
    private int imgtro;
    private String  txtNametro;
    private String  txtgiatro;
    private String  txtdientichtro;
    private String  txtdiachitro;

    public int getImgtro() {
        return imgtro;
    }

    public void setImgtro(int imgtro) {
        this.imgtro = imgtro;
    }

    public String getTxtNametro() {
        return txtNametro;
    }

    public void setTxtNametro(String txtNametro) {
        this.txtNametro = txtNametro;
    }

    public String getTxtgiatro() {
        return txtgiatro;
    }

    public void setTxtgiatro(String txtgiatro) {
        this.txtgiatro = txtgiatro;
    }

    public String getTxtdientichtro() {
        return txtdientichtro;
    }

    public void setTxtdientichtro(String txtdientichtro) {
        this.txtdientichtro = txtdientichtro;
    }

    public String getTxtdiachitro() {
        return txtdiachitro;
    }

    public void setTxtdiachitro(String txtdiachitro) {
        this.txtdiachitro = txtdiachitro;
    }

    public Search(int imgtro, String txtNametro, String txtgiatro, String txtdientichtro, String txtdiachitro) {
        this.imgtro = imgtro;
        this.txtNametro = txtNametro;
        this.txtgiatro = txtgiatro;
        this.txtdientichtro = txtdientichtro;
        this.txtdiachitro = txtdiachitro;
    }
}
