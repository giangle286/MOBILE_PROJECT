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

import com.example.adapters.DecorAdapter;
import com.example.adapters.RoomatesAdapter;
import com.example.models.Decor;
import com.example.models.Roomates;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Roomates extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rcvRoomates;
    private RoomatesAdapter mRoomatesAdapter;
    private Button btnTinNoiBat,btnTinMoiNhat;
    private GridLayoutManager gridLayoutManager;
    Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomates);
        bottomNav();
        rcvRoomates = findViewById(R.id.rcv_roomates);
        btnTinNoiBat=findViewById(R.id.btn_TinNoiBat);
        btnTinMoiNhat=findViewById(R.id.btn_TinMoiNhat);



        mRoomatesAdapter = new RoomatesAdapter(this, getListRoomates());


        gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        rcvRoomates.setLayoutManager(gridLayoutManager);
        mRoomatesAdapter.setData(getListRoomates());
        rcvRoomates.setAdapter(mRoomatesAdapter);

        btnTinMoiNhat.setOnClickListener(this);
        btnTinNoiBat.setOnClickListener(this);
       // btnPost.findViewById(R.id.btn_DangTinRoomates);

        //addEvents();

    }

//    private void addEvents() {
//
//        btnPost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Activity_Roomates.this, Activity_Post_Roomate.class);
//                startActivity(intent);
//            }
//        });
//    }

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

    private List<Roomates> getListRoomates() {
        List<Roomates> Roomateslist = new ArrayList<>();

        Roomateslist.add(new Roomates(Roomates.TYPE_TINMOINHAT,"Phòng trọ 3 người, tìm 1 nữ","Nhà trọ Việt Dũng","0936783819","76/36, Phường Linh Đông, Quận Thủ Đức, Hồ Chí Minh","10 m2",3.0,"Nữ","sạch sẽ đầy đủ tiện nghi ",R.drawable.roomate1));
        Roomateslist.add(new Roomates(Roomates.TYPE_TINMOINHAT,"Phòng trọ 3 người, tìm 1 nữ","Nhà trọ Việt Dũng","0936783819","76/36, Phường Linh Đông, Quận Thủ Đức, Hồ Chí Minh","10 m2",3.0,"Nữ","sạch sẽ đầy đủ tiện nghi ",R.drawable.roomate2));
        Roomateslist.add(new Roomates(Roomates.TYPE_TINMOINHAT,"Phòng trọ 3 người, tìm 1 nữ","Nhà trọ Việt Dũng","0936783819","76/36, Phường Linh Đông, Quận Thủ Đức, Hồ Chí Minh","10 m2",3.0,"Nữ","sạch sẽ đầy đủ tiện nghi ",R.drawable.roomate3));
        Roomateslist.add(new Roomates(Roomates.TYPE_TINMOINHAT,"Phòng trọ 3 người, tìm 1 nữ","Nhà trọ Việt Dũng","0936783819","76/36, Phường Linh Đông, Quận Thủ Đức, Hồ Chí Minh","10 m2",3.0,"Nữ","sạch sẽ đầy đủ tiện nghi ",R.drawable.roomate4));

        return Roomateslist;

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_TinNoiBat:
                scrollToItem(2);
                break;
            case R.id.btn_TinMoiNhat:
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
