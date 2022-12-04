package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

public class Activity_Blog_Details extends AppCompatActivity {

    private ImageView imvFavorite;

    ListView lvCmt;
    private Button btnCmt;
    private EditText edtCmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_details);
        ExpandableTextView expTv1 =findViewById(R.id.expand_text_view);
        expTv1.setText(getString(R.string.chitietbaiblog));
        imvFavorite = findViewById(R.id.imv_Favorite);
        lvCmt = findViewById(R.id.lv_cmtBlog);
        btnCmt = findViewById(R.id.btn_AddComment);
        edtCmt = findViewById(R.id.editTextTextPersonName3);
//        initAdapter();


        imvFavorite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageView imvReact=view.findViewById(R.id.imv_Favorite);
                imvReact.setSelected(!imvReact.isSelected());
                if(imvReact.isSelected()){
                    imvReact.setImageResource(R.drawable.ic_baseline_favoritefull_24);
                }else {
                    imvReact.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                }
            }
        });

    }

}