package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.DecoCommentAdapter;
import com.example.adapters.DecoSamplesAdapter;
import com.example.adapters.DecorAdapter;
import com.example.models.DecoComment;
import com.example.models.DecoSamples;
import com.example.models.Decor;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Activity_Decor_Details extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decor_details);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }
        Decor decor= (Decor) bundle.get("object_decor");

        ImageView img_DecoDetails=findViewById(R.id.img_DecoDetails);
        img_DecoDetails.setImageResource(decor.getResourceImage());
        TextView txtNameDecor=findViewById(R.id.txt_NameDecorDetails);
        txtNameDecor.setText(decor.getNameDecor());
        TextView txtUserDecor=findViewById(R.id.txt_UserDecorDetails);
        txtUserDecor.setText(decor.getUserDecor());
        TextView txtTimeDecor=findViewById(R.id.txt_TimeDecorDetails);
        txtTimeDecor.setText(decor.getTimeDecor());


    }




}