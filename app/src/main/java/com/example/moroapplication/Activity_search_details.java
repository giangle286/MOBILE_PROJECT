package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.Home;
import com.example.models.Search;

public class Activity_search_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_details);
        Bundle bundle = getIntent().getExtras();
        if (bundle== null)
        { return;
        }
        Search search=(Search) bundle.get("object_search");

        ImageView imv_giatro =findViewById(R.id.imv_searchhinh);

        imv_giatro.setImageResource(search.getImgtro());

      //  TextView txtgiatro=findViewById(R.id.txt_price);
    //    txtgiatro.setText(search.getTxtgiatro());
        TextView txtdiachitro=findViewById(R.id.txt_address);
        txtdiachitro.setText(search.getTxtdiachitro());
        TextView txtdientichtro=findViewById(R.id.txt_square);
        txtdientichtro.setText(search.getTxtdientichtro());
        TextView txtNametro=findViewById(R.id.txt_searchten);
        txtNametro.setText(search.getTxtNametro());
    }
}