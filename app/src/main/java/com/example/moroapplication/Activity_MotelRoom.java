package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.adapters.MotelRoomAdapter;
import com.example.adapters.RoomatesAdapter;
import com.example.models.MotelRoom;
import com.example.models.Roomates;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Activity_MotelRoom extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rcvMotelRoom;
    private MotelRoomAdapter mMotelRoomAdapter;
    private Button btnTinNoiBatMotelRoom,btnTinMoiNhatMotelRoom;
    private GridLayoutManager gridLayoutManager;
    Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motel_room);
        bottomNav();

        rcvMotelRoom = findViewById(R.id.rcv_MotelRoom);
        btnTinNoiBatMotelRoom=findViewById(R.id.btn_TinNoiBat_MotelRoom);
        btnTinMoiNhatMotelRoom=findViewById(R.id.btn_TinMoiNhat_MotelRoom);
        btnPost = findViewById(R.id.btn_DangTinMotelRoom);



        mMotelRoomAdapter = new MotelRoomAdapter(this, getListMotelRoom());


        gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        rcvMotelRoom.setLayoutManager(gridLayoutManager);
        mMotelRoomAdapter.setData(getListMotelRoom());
        rcvMotelRoom.setAdapter(mMotelRoomAdapter);

        btnTinMoiNhatMotelRoom.setOnClickListener(this);
        btnTinNoiBatMotelRoom.setOnClickListener(this);


        addEvents();
    }

    private void addEvents() {
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MotelRoom.this, Activity_Post_Rent.class);
                startActivity(intent);
            }
        });
    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_notification);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_account:
                        startActivity(new Intent(getApplicationContext(),Activity_Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_homepage:
                        startActivity(new Intent(getApplicationContext(),Activity_Homepage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_news:
                        startActivity(new Intent(getApplicationContext(),Activity_Blog.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_decor:
                        startActivity(new Intent(getApplicationContext(),Activity_Decor.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_notification:
                        startActivity(new Intent(getApplicationContext(),Activity_Notification.class));
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });
    }

    private List<MotelRoom> getListMotelRoom() {
        List<MotelRoom> MotelRoomlist = new ArrayList<>();

        MotelRoomlist.add(new MotelRoom(MotelRoom.TYPE_TINNOIBATMOTELROOM,"Phòng cho thuê quận 11", "Phòng trọ Hà Nội", "0989797454", "Hà Nội", "100m2",3.0,"2,5 triệu","Sang xịn mịn",R.drawable.img_nt1));
        MotelRoomlist.add(new MotelRoom(MotelRoom.TYPE_TINMOINHATMOTELROOM,"Phòng cho thuê quận 11,","Phòng trọ Hà Nội", "0989797454", "Hà Nội", "100m2",3.0,"2 triệu","Sang xịn mịn",R.drawable.img_nt2));
        MotelRoomlist.add(new MotelRoom(MotelRoom.TYPE_TINNOIBATMOTELROOM,"Phòng cho thuê quận 11", "Phòng trọ Hà Nội", "0989797454", "Hà Nội", "100m2",3.0,"4 triệu","Sang xịn mịn",R.drawable.img_nt3));
        MotelRoomlist.add(new MotelRoom(MotelRoom.TYPE_TINMOINHATMOTELROOM,"Phòng cho thuê quận 11", "Phòng trọ Hà Nội", "0989797454", "Hà Nội", "100m2",3.0,"3,5 triệu","Sang xịn mịn",R.drawable.img_nt4));
        MotelRoomlist.add(new MotelRoom(MotelRoom.TYPE_TINMOINHATMOTELROOM,"Phòng cho thuê quận 11", "Phòng trọ Hà Nội", "0989797454", "Hà Nội", "100m2",3.0,"3 triệu","Sang xịn mịn",R.drawable.img_nt5));
        MotelRoomlist.add(new MotelRoom(MotelRoom.TYPE_TINNOIBATMOTELROOM, "Phòng cho thuê quận 11","Phòng trọ Hà Nội", "0989797454", "Hà Nội", "100m2",3.0,"2,5 triệu","Sang xịn mịn",R.drawable.img_nt1));

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
