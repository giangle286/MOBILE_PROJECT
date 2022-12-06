package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.Home;

public class activity_rental_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_details);
        Bundle bundle = getIntent().getExtras();
        if (bundle== null)
        { return;
    }
        Home home=(Home) bundle.get("object_home");
       
        ImageView imv_giatro =findViewById(R.id.imv_trochothue);

        imv_giatro.setImageResource(home.getImgtro());
        TextView txtgiatro=findViewById(R.id.txt_price);
        txtgiatro.setText(home.getTxtgiatro());
         TextView txtdiachitro=findViewById(R.id.txt_address);
        txtdiachitro.setText(home.getTxtdiachitro());
         TextView txtdientichtro=findViewById(R.id.txt_square);
        txtdientichtro.setText(home.getTxtdientichtro());
        TextView txtNametro=findViewById(R.id.txt_namerental);
        txtNametro.setText(home.getTxtNametro());


    }
}