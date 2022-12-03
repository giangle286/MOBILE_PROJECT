package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.adapters.DecoCategoryAdapter;
import com.example.interfaces.IClickItemDecoListener;
import com.example.models.Deco;
import com.example.models.DecoCategory;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Deco extends AppCompatActivity {
    private RecyclerView rcvdecoCategory;
    private DecoCategoryAdapter decoCategoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deco);
        rcvdecoCategory=findViewById(R.id.rcv_decoCategory);
        decoCategoryAdapter=new DecoCategoryAdapter(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvdecoCategory.setLayoutManager(linearLayoutManager);
        decoCategoryAdapter.setData(getListDecoCategory());
        rcvdecoCategory.setAdapter(decoCategoryAdapter);
        bottomNav();
        addEvent();
    }

    private void addEvent() {
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

    private List<DecoCategory> getListDecoCategory(){
        List<DecoCategory>listDecoCategory=new ArrayList<>();
        List<Deco>decoList=new ArrayList<>();
        List<Deco>decoList1=new ArrayList<>();
        List<Deco>decoList2=new ArrayList<>();
        List<Deco>decoList3=new ArrayList<>();


        decoList.add(new Deco(R.drawable.sample1,"Decor tối giản","Nhật Linh","2 phút trước"));
        decoList.add(new Deco(R.drawable.sample2,"Phòng công chúa","Thùy Dung","10 phút trước"));
        decoList.add(new Deco(R.drawable.sample3,"Mẫu deco đẹp","Linh Anh","20 phút trước"));
        decoList.add(new Deco(R.drawable.sample1,"Decor tối giản","Nhật Linh","2 phút trước"));
        decoList.add(new Deco(R.drawable.sample2,"Phòng công chúa","Thùy Dung","10 phút trước"));
        decoList.add(new Deco(R.drawable.sample3,"Mẫu deco đẹp","Linh Anh","20 phút trước"));

        decoList1.add(new Deco(R.drawable.sample4,"Mẫu Vinatge","Thủy Anh","40 phút trước"));
        decoList1.add(new Deco(R.drawable.sample5,"My room","Khánh Linh","1 ngày trước"));
        decoList1.add(new Deco(R.drawable.sample6,"Decor siêu xinh ","Tiến Anh","2 tiếng trước"));
        decoList1.add(new Deco(R.drawable.sample4,"Mẫu Vinatge","Thủy Anh","56 phút trước"));
        decoList1.add(new Deco(R.drawable.sample5,"My room","Khánh Linh","3 ngày trước"));
        decoList1.add(new Deco(R.drawable.sample6,"Decor siêu xinh ","Tiến Anh","23 phút trước"));

        decoList2.add(new Deco(R.drawable.sample7,"Đơn giản vẫn đẹp","Trúc Anh","12 phút trước"));
        decoList2.add(new Deco(R.drawable.sample8,"Mẫu phòng tối giản","Ngân Hà","5 ngày trước"));
        decoList2.add(new Deco(R.drawable.sample9,"Phòng đẹp của tôi","Phương Linh","21 phút trước"));
        decoList2.add(new Deco(R.drawable.sample7,"Đơn giản vẫn đẹp","Trúc Anh","12 phút trước"));
        decoList2.add(new Deco(R.drawable.sample8,"Mẫu phòng tối giản","Ngân Hà","5 ngày trước"));
        decoList2.add(new Deco(R.drawable.sample9,"Phòng đẹp của tôi","Phương Linh","21 phút trước"));

        decoList3.add(new Deco(R.drawable.sample10,"Phòng hiện đại ","Hương Trang","10 giờ trước"));
        decoList3.add(new Deco(R.drawable.sample11,"Sang xịn mịn ","Thế Anh","19 giờ trước"));
        decoList3.add(new Deco(R.drawable.sample12,"My modern room ","Thế Phát","11 giờ trước"));
        decoList3.add(new Deco(R.drawable.sample13,"Phòng hiện đại ","Hương Trang","10 giờ trước"));
        decoList3.add(new Deco(R.drawable.sample11,"Sang xịn mịn ","Thế Anh","19 giờ trước"));
        decoList3.add(new Deco(R.drawable.sample12,"My modern room ","Thế Phát","11 giờ trước"));






        listDecoCategory.add(new DecoCategory("Bài đăng mới nhất",decoList));
        listDecoCategory.add(new DecoCategory("Phong cách vintage",decoList1));
        listDecoCategory.add(new DecoCategory("Phong cách tối giản",decoList2));
        listDecoCategory.add(new DecoCategory("Phong cách hiện đại",decoList3));

        return listDecoCategory;
    }

}