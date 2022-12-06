package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.adapters.ProfileChoosingAdapter;
import com.example.models.ProfileChoosing;
import com.example.moroapplication.databinding.ActivityProfileBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Profile extends AppCompatActivity {
    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_profile);
        setContentView(binding.getRoot());
        bottomNav();
        addEvents();
    }
    private ProfileChoosingAdapter profileChoosingAdapter;
    private void addEvents() {

    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_notification);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_account:
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
                        startActivity(new Intent(getApplicationContext(),Activity_Deco.class));
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
    ListView lvProfileChoosing = findViewById(R.id.lv_profile_function);
    private List<ProfileChoosing> ListProfileChoosing(){
        List<ProfileChoosing>ListProfileChoosing=new ArrayList<>();
        ListProfileChoosing.add(new ProfileChoosing("Quản lý tài khoản"));
        ListProfileChoosing.add(new ProfileChoosing("Xem mục lưu trữ"));
       ListProfileChoosing.add(new ProfileChoosing("Xem báo cáo"));
       ListProfileChoosing.add(new ProfileChoosing("Đăng xuất"));
        ListProfileChoosing.add(new ProfileChoosing("Trợ giúp"));
       return ListProfileChoosing;

    }}