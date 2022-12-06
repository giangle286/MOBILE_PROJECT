package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adapters.DecorAdapter;
import com.example.adapters.RoomatesAdapter;
import com.example.models.Decor;
import com.example.models.Roomates;

import java.util.ArrayList;
import java.util.List;

public class Activity_Roomates extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rcvRoomates;
    private RoomatesAdapter mRoomatesAdapter;
    private Button btnTinNoiBat,btnTinMoiNhat;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomates);

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



    }

    private List<Roomates> getListRoomates() {
        List<Roomates> Roomateslist = new ArrayList<>();

        Roomateslist.add(new Roomates(Roomates.TYPE_TINMOINHAT,"Nhà trọ Việt Dũng","0936783819","76/36, Phường Linh Đông, Quận Thủ Đức, Hồ Chí Minh","10 m2",3.0,"Nữ","sạch sẽ đầy đủ tiện nghi ",R.drawable.roomate1));
        Roomateslist.add(new Roomates(Roomates.TYPE_TINMOINHAT,"Nhà trọ Việt Dũng","0936783819","76/36, Phường Linh Đông, Quận Thủ Đức, Hồ Chí Minh","10 m2",3.0,"Nữ","sạch sẽ đầy đủ tiện nghi ",R.drawable.roomate2));
        Roomateslist.add(new Roomates(Roomates.TYPE_TINMOINHAT,"Nhà trọ Việt Dũng","0936783819","76/36, Phường Linh Đông, Quận Thủ Đức, Hồ Chí Minh","10 m2",3.0,"Nữ","sạch sẽ đầy đủ tiện nghi ",R.drawable.roomate3));
        Roomateslist.add(new Roomates(Roomates.TYPE_TINMOINHAT,"Nhà trọ Việt Dũng","0936783819","76/36, Phường Linh Đông, Quận Thủ Đức, Hồ Chí Minh","10 m2",3.0,"Nữ","sạch sẽ đầy đủ tiện nghi ",R.drawable.roomate4));

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
