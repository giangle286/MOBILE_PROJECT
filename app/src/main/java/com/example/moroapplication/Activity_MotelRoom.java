package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adapters.MotelRoomAdapter;
import com.example.adapters.RoomatesAdapter;
import com.example.models.MotelRoom;
import com.example.models.Roomates;

import java.util.ArrayList;
import java.util.List;

public class Activity_MotelRoom extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rcvMotelRoom;
    private MotelRoomAdapter mMotelRoomAdapter;
    private Button btnTinNoiBatMotelRoom,btnTinMoiNhatMotelRoom;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motel_room);

        rcvMotelRoom = findViewById(R.id.rcv_MotelRoom);
        btnTinNoiBatMotelRoom=findViewById(R.id.btn_TinNoiBat_MotelRoom);
        btnTinMoiNhatMotelRoom=findViewById(R.id.btn_TinMoiNhat_MotelRoom);



        mMotelRoomAdapter = new MotelRoomAdapter(this, getListMotelRoom());


        gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        rcvMotelRoom.setLayoutManager(gridLayoutManager);
        mMotelRoomAdapter.setData(getListMotelRoom());
        rcvMotelRoom.setAdapter(mMotelRoomAdapter);

        btnTinMoiNhatMotelRoom.setOnClickListener(this);
        btnTinNoiBatMotelRoom.setOnClickListener(this);



    }

    private List<MotelRoom> getListMotelRoom() {
        List<MotelRoom> MotelRoomlist = new ArrayList<>();

        MotelRoomlist.add(new MotelRoom(MotelRoom.TYPE_TINNOIBATMOTELROOM, "Phòng trọ 1", "1000000", "Hà Nội", "100m2",3.0,"2.500.000","Sàn xịn mịn",R.drawable.img_nt1));

        //private int TypeMotelRoom;
        //    private String nameMotelRoom;
        //    private String phoneMotelRoom;
        //    private String addressMotelRoom;
        //    private String squareMotelRoom;
        //    private Double nobMotelRoom;
        //    private String priceMotelRoom;
        //    private String describeMotelRoom;
        //    private int resourceImage;
        return MotelRoomlist;

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_TinNoiBat_MotelRoom:
                scrollToItem(2);
                break;
            case R.id.btn_TinMoiNhat_MotelRoom:
                scrollToItem(1);
                break;

        }

    }

    private void scrollToItem(int index) {
        if(gridLayoutManager==null){
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(index,0);
    }
}
