package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adapters.DecorAdapter;
import com.example.models.Deco;
import com.example.models.Decor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Decor extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcvDecor;
    private DecorAdapter mDecorAdapter;
    private Button btnVintage,btnToiGian,btnHienDai;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decor);

        rcvDecor = findViewById(R.id.rcv_decor);
        btnVintage=findViewById(R.id.btn_Vintage);
        btnToiGian=findViewById(R.id.btn_ToiGian);
        btnHienDai=findViewById(R.id.btn_HienDai);
        bottomNav();



        mDecorAdapter = new DecorAdapter(this, getListDecor());


        gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        rcvDecor.setLayoutManager(gridLayoutManager);
        mDecorAdapter.setData(getListDecor());
        rcvDecor.setAdapter(mDecorAdapter);

        btnVintage.setOnClickListener(this);
        btnToiGian.setOnClickListener(this);
        btnHienDai.setOnClickListener(this);



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
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_news:
                        startActivity(new Intent(getApplicationContext(),Activity_Blog.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_decor:
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

    private List<Decor> getListDecor() {
        List<Decor> list = new ArrayList<>();

        list.add(new Decor(R.drawable.sample7,"Đơn giản vẫn đẹp","Trúc Anh","12 phút trước",Decor.TYPE_HIENDAI));
        list.add(new Decor(R.drawable.sample8,"Mẫu phòng tối giản","Ngân Hà","5 ngày trước", Decor.TYPE_TOIGIAN));
        list.add(new Decor(R.drawable.sample9,"Phòng đẹp của tôi","Phương Linh","21 phút trước", Decor.TYPE_VINTAGE));;
        list.add(new Decor(R.drawable.sample7,"Đơn giản vẫn đẹp","Trúc Anh","12 phút trước",Decor.TYPE_HIENDAI));
        list.add(new Decor(R.drawable.sample8,"Mẫu phòng tối giản","Ngân Hà","5 ngày trước", Decor.TYPE_TOIGIAN));
        list.add(new Decor(R.drawable.sample9,"Phòng đẹp của tôi","Phương Linh","21 phút trước", Decor.TYPE_VINTAGE));;


        list.add(new Decor(R.drawable.sample4,"Mẫu Vinatge","Thủy Anh","40 phút trước",Decor.TYPE_VINTAGE));
        list.add(new Decor(R.drawable.sample5,"My room","Khánh Linh","1 ngày trước",Decor.TYPE_VINTAGE));
        list.add(new Decor(R.drawable.sample6,"Decor siêu xinh ","Tiến Anh","2 tiếng trước",Decor.TYPE_VINTAGE));
        list.add(new Decor(R.drawable.sample4,"Mẫu Vinatge","Thủy Anh","56 phút trước",Decor.TYPE_VINTAGE));
        list.add(new Decor(R.drawable.sample5,"My room","Khánh Linh","3 ngày trước",Decor.TYPE_VINTAGE));
        list.add(new Decor(R.drawable.sample6,"Decor siêu xinh ","Tiến Anh","23 phút trước",Decor.TYPE_VINTAGE));


        list.add(new Decor(R.drawable.sample1, "Decor tối giản", "Nhật Linh", "2 phút trước",Decor.TYPE_TOIGIAN));
        list.add(new Decor(R.drawable.sample2, "Phòng công chúa", "Thùy Dung", "10 phút trước",Decor.TYPE_TOIGIAN));
        list.add(new Decor(R.drawable.sample3, "Mẫu deco đẹp", "Linh Anh", "20 phút trước",Decor.TYPE_TOIGIAN));
        list.add(new Decor(R.drawable.sample1, "Decor tối giản", "Nhật Linh", "2 phút trước",Decor.TYPE_TOIGIAN));
        list.add(new Decor(R.drawable.sample2, "Phòng công chúa", "Thùy Dung", "10 phút trước",Decor.TYPE_TOIGIAN));
        list.add(new Decor(R.drawable.sample3, "Mẫu deco đẹp", "Linh Anh", "20 phút trước",Decor.TYPE_TOIGIAN));

        list.add(new Decor(R.drawable.sample10,"Phòng hiện đại ","Hương Trang","10 giờ trước",Decor.TYPE_HIENDAI));
        list.add(new Decor(R.drawable.sample11,"Sang xịn mịn ","Thế Anh","19 giờ trước",Decor.TYPE_HIENDAI));
        list.add(new Decor(R.drawable.sample12,"My modern room ","Thế Phát","11 giờ trước",Decor.TYPE_HIENDAI));
        list.add(new Decor(R.drawable.sample13,"Phòng hiện đại ","Hương Trang","10 giờ trước",Decor.TYPE_HIENDAI));
        list.add(new Decor(R.drawable.sample11,"Sang xịn mịn ","Thế Anh","19 giờ trước",Decor.TYPE_HIENDAI));
        list.add(new Decor(R.drawable.sample12,"My modern room ","Thế Phát","11 giờ trước",Decor.TYPE_HIENDAI));




        return list;

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_Vintage:
                scrollToItem(2);
                break;
            case R.id.btn_ToiGian:
                scrollToItem(1);
                break;
            case R.id.btn_HienDai:
                scrollToItem(0);

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







