package com.example.models;

import android.widget.ImageView;
import android.widget.TextView;

public class Trangsautimkiem {
  //  private String Txtnametimkiem;
    //  private String Txtgiatimkiem;
 //   private String Txtdientichtimkiem;
    private int Imvtimkiem;
    private String Txtdiachitimkiem;

   // public String getTxtnametimkiem() {
 //       return Txtnametimkiem;
 //   }

   // public void setTxtnametimkiem(String txtnametimkiem) {
   //     this.Txtnametimkiem = txtnametimkiem;
  //  }

 //   public String getTxtgiatimkiem() {
 //       return Txtgiatimkiem;
  //  }

  //  public void setTxtgiatimkiem(String txtgiatimkiem) {
  //      this.Txtgiatimkiem = txtgiatimkiem;
  //  }

  //  public String getTxtdientichtimkiem() {
  //      return Txtdientichtimkiem;
   // }

  //  public void setTxtdientichtimkiem(String txtdientichtimkiem) {
  //      this.Txtdientichtimkiem = txtdientichtimkiem;
  //  }

    public int getImvtimkiem() {
        return Imvtimkiem;
    }

    public void setImvtimkiem(int imvtimkiem) {
        this.Imvtimkiem = imvtimkiem;
    }

    public String getTxtdiachitimkiem() {
        return Txtdiachitimkiem;
    }


    public void setTxtdiachitimkiem(String txtdiachitimkiem) {
        this.Txtdiachitimkiem = txtdiachitimkiem;
    }

    public Trangsautimkiem(int imvtimkiem, String txtdiachitimkiem) {
    //    Txtnametimkiem = txtnametimkiem;
     //   Txtgiatimkiem = txtgiatimkiem;
     //   Txtdientichtimkiem = txtdientichtimkiem;
        Imvtimkiem = imvtimkiem;
        Txtdiachitimkiem = txtdiachitimkiem;
    }
}
//Trang sau tìm kiếm update