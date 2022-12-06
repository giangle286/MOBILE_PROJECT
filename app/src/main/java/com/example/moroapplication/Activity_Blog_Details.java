package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.DecoCommentAdapter;
import com.example.models.DecoComment;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

public class Activity_Blog_Details extends AppCompatActivity {

    private ImageView imvFavorite;

    DecoCommentAdapter decoCommentAdapter;
    ArrayList<DecoComment> decoComment;

    ListView lvCmt;
    private Button btnCmt;
    private EditText edtCmt;
    private TextView txtTitle, txtTime;
    private ImageView imvBlogDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_details);
        ExpandableTextView expTv1 =findViewById(R.id.expand_text_view);
        expTv1.setText(getString(R.string.chitietbaiblog));
        imvFavorite = findViewById(R.id.imv_Favorite);

//        initAdapter();
        linkViews();
        addEvents();
        initData();
        showData();


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

    private void showData() {

            Intent intent = getIntent();
            int selectbeer = intent.getIntExtra("selectimage",0);
            String selectime = intent.getStringExtra("selectime");
            String selecttitle = intent.getStringExtra("selecttitle");
            txtTime.setText(selectime);
            txtTitle.setText(selecttitle);
            imvBlogDetails.setImageResource(selectbeer);
    }

    private void addEvents() {
        btnCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                comment=new ArrayList<>();
                decoComment.add(new DecoComment(edtCmt.getText().toString(),"Ngọc Ngọc"));
                decoCommentAdapter=new DecoCommentAdapter(Activity_Blog_Details.this,R.layout.item_cmt,decoComment);
                lvCmt.setAdapter(decoCommentAdapter);
            }
        });
    }

    private void linkViews() {
        lvCmt = findViewById(R.id.lv_cmtBlog);
        btnCmt = findViewById(R.id.btn_AddComment);
        edtCmt = findViewById(R.id.editTextTextPersonName3);
        txtTitle = findViewById(R.id.txt_Title);
        imvBlogDetails = findViewById(R.id.imv_blogDetails);
        txtTime = findViewById(R.id.txt_Time);
    }

    private void initData() {
        decoComment=new ArrayList<>();
        decoComment.add(new DecoComment("Bài viết thật hữu ích","Giang Nguyễn"));
        //decoComment.add(new DecoComment("Xịn quá ạ","Khánh Lê"));
        decoCommentAdapter=new DecoCommentAdapter(Activity_Blog_Details.this,R.layout.item_cmt,decoComment);
        lvCmt.setAdapter(decoCommentAdapter);
        
    }

}