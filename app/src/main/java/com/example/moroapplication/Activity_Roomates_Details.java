package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.DecoCommentAdapter;
import com.example.models.DecoComment;
import com.example.models.Decor;
import com.example.models.Roomates;

import java.util.ArrayList;

public class Activity_Roomates_Details extends AppCompatActivity {

    private EditText edtCmtRoomatesDetails;
    private ImageView imvSendCmtRoomatesDetails;
    ListView lvCmtRoomatesDetails;
    DecoCommentAdapter decoCommentAdapter;
    ArrayList<DecoComment> decoComment;
    ImageButton imb_RoomatesBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomates_details);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }
        Roomates roomates= (Roomates) bundle.get("object_roomates");
        TextView txtTitleRoomates=findViewById(R.id.txt_TitleRoomatesDetails);
        txtTitleRoomates.setText(roomates.getTitleRoomates());


        TextView txtNameRoomates=findViewById(R.id.txt_NameRoomatesDetails);
        txtNameRoomates.setText(roomates.getNameRoomates());
        TextView txtPhoneRoomates=findViewById(R.id.txt_PhoneRoomatesDetails);
        txtPhoneRoomates.setText(roomates.getPhoneRoomates());
        TextView txtAddressRoomates=findViewById(R.id.txt_AddressRoomatesDetails);
        txtAddressRoomates.setText(roomates.getAddressRoomates());
        TextView txtSquareRoomates=findViewById(R.id.txt_SquareRoomatesDetails);
        txtSquareRoomates.setText(roomates.getSquareRoomates());
        TextView txtNobRoomates=findViewById(R.id.txt_NOBRoomatesDetails);
        txtNobRoomates.setText(roomates.getNobRoomates().toString());
        TextView txtGenderRoomates=findViewById(R.id.txt_GenderRoomatesDetails);
        txtGenderRoomates.setText(roomates.getGenderRoomates());
        TextView txtDescribeRoomates=findViewById(R.id.txt_DescribeRoomatesDetails);
        txtDescribeRoomates.setText(roomates.getDescribeRoomates());


        ImageView imv_Roomates=findViewById(R.id.imv_ImageRoomatesDetails);
        imv_Roomates.setImageResource(roomates.getResourceImage());



        linkView();
        addEvent();
        initAdapter();
        initData();



    }
    private void linkView() {
        edtCmtRoomatesDetails=findViewById(R.id.edt_CmtRoomatesDetails);
        imvSendCmtRoomatesDetails=findViewById(R.id.imv_SendCmtRoomatesDetails);
        lvCmtRoomatesDetails=findViewById(R.id.lvCmtRoomatesDetails);
    }

    private void initData() {
        decoComment=new ArrayList<>();
        decoComment.add(new DecoComment("Rất xinh đẹp tuyệt vời","Linh Anh"));
        decoComment.add(new DecoComment("Xịn quá ạ","Khánh Ngân"));
        decoCommentAdapter=new DecoCommentAdapter(Activity_Roomates_Details.this,R.layout.item_cmt,decoComment);
        lvCmtRoomatesDetails.setAdapter(decoCommentAdapter);
    }

    private void addEvent() {
        imvSendCmtRoomatesDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                comment=new ArrayList<>();
                decoComment.add(new DecoComment(edtCmtRoomatesDetails.getText().toString(),"Tiểu Vy"));
                decoCommentAdapter=new DecoCommentAdapter(Activity_Roomates_Details.this,R.layout.item_cmt,decoComment);
                lvCmtRoomatesDetails.setAdapter(decoCommentAdapter);
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