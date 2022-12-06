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
import com.example.models.MotelRoom;
import com.example.models.Roomates;

import java.util.ArrayList;

public class Activity_MotelRoom_Details extends AppCompatActivity {

    private EditText edtCmtMotelRoomDetails;
    private ImageView imvSendCmtMotelRoomDetails;
    ListView lvCmtMotelRoomDetails;
    DecoCommentAdapter decoCommentAdapter;
    ArrayList<DecoComment> decoComment;
    ImageButton imb_MotelRoomBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motel_room_details);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }
        MotelRoom motelroom= (MotelRoom) bundle.get("object_motelroom");
        TextView txtTitleMotelRoom=findViewById(R.id.txt_TitleMotelRoomDetails);
        txtTitleMotelRoom.setText(motelroom.getTypeMotelRoom()+","+motelroom.getNobMotelRoom()+","+motelroom.getPriceMotelRoom()+","+motelroom.getAddressMotelRoom());


        TextView txtNameRoomates=findViewById(R.id.txt_NameMotelRoomDetails);
        txtNameRoomates.setText(motelroom.getNameMotelRoom());
        TextView txtPhoneRoomates=findViewById(R.id.txt_PhoneMotelRoomDetails);
        txtPhoneRoomates.setText(motelroom.getPhoneMotelRoom());
        TextView txtAddressRoomates=findViewById(R.id.txt_AddressMotelRoomDetails);
        txtAddressRoomates.setText(motelroom.getAddressMotelRoom());
        TextView txtSquareRoomates=findViewById(R.id.txt_SquareMotelRoomDetails);
        txtSquareRoomates.setText(motelroom.getSquareMotelRoom());
        TextView txtNobRoomates=findViewById(R.id.txt_NOBMotelRoomDetails);
        txtNobRoomates.setText(motelroom.getNobMotelRoom().toString());
        TextView txtGenderRoomates=findViewById(R.id.txt_PriceMotelRoomDetails);
        txtGenderRoomates.setText(motelroom.getPriceMotelRoom());
        TextView txtDescribeRoomates=findViewById(R.id.txt_DescribeMotelRoomDetails);
        txtDescribeRoomates.setText(motelroom.getDescribeMotelRoom());


        ImageView imv_MotelRoom=findViewById(R.id.imv_ImageMotelRoomDetails);
        imv_MotelRoom.setImageResource(motelroom.getResourceImage());



        linkView();
        addEvent();
        initAdapter();
        initData();



    }
    private void linkView() {
        edtCmtMotelRoomDetails=findViewById(R.id.edt_CmtMotelRoomDetails);
        imvSendCmtMotelRoomDetails=findViewById(R.id.imv_SendCmtMotelRoomDetails);
        lvCmtMotelRoomDetails=findViewById(R.id.lvCmtMotelRoomsDetails);
    }

    private void initData() {
        decoComment=new ArrayList<>();
        decoComment.add(new DecoComment("Rất xinh đẹp tuyệt vời","Linh Anh"));
        decoComment.add(new DecoComment("Xịn quá ạ","Khánh Ngân"));
        decoCommentAdapter=new DecoCommentAdapter(Activity_MotelRoom_Details.this,R.layout.item_cmt,decoComment);
        lvCmtMotelRoomDetails.setAdapter(decoCommentAdapter);
    }

    private void addEvent() {
        imvSendCmtMotelRoomDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                comment=new ArrayList<>();
                decoComment.add(new DecoComment(edtCmtMotelRoomDetails.getText().toString(),"Tiểu Vy"));
                decoCommentAdapter=new DecoCommentAdapter(Activity_MotelRoom_Details.this,R.layout.item_cmt,decoComment);
                lvCmtMotelRoomDetails.setAdapter(decoCommentAdapter);
            }

        });


    }

    private void initAdapter() {
    }
}