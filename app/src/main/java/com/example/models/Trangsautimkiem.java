package com.example.models;

import android.widget.ImageView;
import android.widget.TextView;

public class Trangsautimkiem {
    private String txtnametimkiem;
    private String txtgiatimkiem;
    private String txtdientichtimkiem;
    private int imvtimkiem;
    private String txtdiachitimkiem;

    public String getTxtnametimkiem() {
        return txtnametimkiem;
    }

    public void setTxtnametimkiem(String txtnametimkiem) {
        this.txtnametimkiem = txtnametimkiem;
    }

    public String getTxtgiatimkiem() {
        return txtgiatimkiem;
    }

    public void setTxtgiatimkiem(String txtgiatimkiem) {
        this.txtgiatimkiem = txtgiatimkiem;
    }

    public String getTxtdientichtimkiem() {
        return txtdientichtimkiem;
    }

    public void setTxtdientichtimkiem(String txtdientichtimkiem) {
        this.txtdientichtimkiem = txtdientichtimkiem;
    }

    public int getImvtimkiem() {
        return imvtimkiem;
    }

    public void setImvtimkiem(int imvtimkiem) {
        this.imvtimkiem = imvtimkiem;
    }

    public String getTxtdiachitimkiem() {
        return txtdiachitimkiem;
    }




    public void setTxtdiachitimkiem(String txtdiachitimkiem) {
        this.txtdiachitimkiem = txtdiachitimkiem;
    }

    public Trangsautimkiem(String txtnametimkiem, String txtgiatimkiem, String txtdientichtimkiem, int imvtimkiem, String txtdiachitimkiem) {
        txtnametimkiem = txtnametimkiem;
        txtgiatimkiem = txtgiatimkiem;
        txtdientichtimkiem = txtdientichtimkiem;
        imvtimkiem = imvtimkiem;
        txtdiachitimkiem = txtdiachitimkiem;
    }
}