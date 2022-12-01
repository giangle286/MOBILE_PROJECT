package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.adapters.DecoCategoryAdapter;
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
        decoList.add(new Deco(R.drawable.sample1,"Phòng công chúa","Nhật Vy","2 phút trước"));
        decoList.add(new Deco(R.drawable.sample2,"Phòng xịn","Huy Hoàng","10 phút trước"));
        decoList.add(new Deco(R.drawable.sample3,"Phòng sang","Linh Anh","20 phút trước"));

        decoList.add(new Deco(R.drawable.sample1,"Phòng công chúa","Nhật Vy","2 phút trước"));
        decoList.add(new Deco(R.drawable.sample2,"Phòng xịn","Huy Hoàng","10 phút trước"));
        decoList.add(new Deco(R.drawable.sample3,"Phòng sang","Linh Anh","20 phút trước"));

        listDecoCategory.add(new DecoCategory("Bài đăng mới nhất",decoList));
        listDecoCategory.add(new DecoCategory("Phong cách tối giản",decoList));
        listDecoCategory.add(new DecoCategory("Phong cách vintage",decoList));
        listDecoCategory.add(new DecoCategory("Phong cách hiện đại",decoList));




        return listDecoCategory;
    }
}