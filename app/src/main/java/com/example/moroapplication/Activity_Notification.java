package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.adapters.NotificationAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Activity_Notification extends AppCompatActivity {

    ListView lvNotification;
    ArrayList<com.example.models.Notification> notifications;
    NotificationAdapter notificationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        linkView();
        initData();
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
                        startActivity(new Intent(getApplicationContext(),Activity_Deco.class));
                        overridePendingTransition(0,0);
                    case R.id.action_notification:
                        return true;

                }

                return false;
            }
        });
    }

    private void initData() {
        notifications = new ArrayList<>();
        notifications.add(new com.example.models.Notification("Mỹ Lệ Trần đã thích bài viết của bạn"));
        notifications.add(new com.example.models.Notification("Bảo Ngọc đã bình luận bài viết của bạn"));
        notifications.add(new com.example.models.Notification("Bạn vừa tải lên một bài viết"));
        notifications.add(new com.example.models.Notification("Nguyễn Lý và 3 người khác đã thích bài viết của bạn"));
        notifications.add(new com.example.models.Notification("Mai Mai đã gửi một tin nhắn đến Nhóm nhà trọ 777"));
        notifications.add(new com.example.models.Notification("Lý Lệ Tuyền đã thích bài viết của bạn"));
        notificationAdapter = new NotificationAdapter(this, notifications);
        lvNotification.setAdapter(notificationAdapter);
    }



    private void linkView() {
        lvNotification = findViewById(R.id.lvNotification);
    }
}