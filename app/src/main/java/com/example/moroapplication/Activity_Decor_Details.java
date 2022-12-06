package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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
    private EditText edtCmt;
    private ImageView imvSendCmt;
    ListView lvCmt;
    DecoCommentAdapter decoCommentAdapter;
    ArrayList<DecoComment> decoComment;
    ImageButton imb_DecoBack;


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


        linkView();
        addEvent();
        initAdapter();
        initData();



    }
    private void linkView() {
        edtCmt=findViewById(R.id.edt_Cmt);
        imvSendCmt=findViewById(R.id.imv_SendCmt);
        lvCmt=findViewById(R.id.lvCmt);
    }

    private void initData() {
        decoComment=new ArrayList<>();
        decoComment.add(new DecoComment("Rất xinh đẹp tuyệt vời","Linh Anh"));
        decoComment.add(new DecoComment("Xịn quá ạ","Khánh Ngân"));
        decoCommentAdapter=new DecoCommentAdapter(Activity_Decor_Details.this,R.layout.item_cmt,decoComment);
        lvCmt.setAdapter(decoCommentAdapter);
    }

    private void addEvent() {
        imvSendCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                comment=new ArrayList<>();
                decoComment.add(new DecoComment(edtCmt.getText().toString(),"Tiểu Vy"));
                decoCommentAdapter=new DecoCommentAdapter(Activity_Decor_Details.this,R.layout.item_cmt,decoComment);
                lvCmt.setAdapter(decoCommentAdapter);
            }

        });

//        imb_DecoBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Activity_Decor_Details.this,Activity_Decor.class);
//                startActivity(intent);
//            }
//        });

    }

    private void initAdapter() {

    }





}


