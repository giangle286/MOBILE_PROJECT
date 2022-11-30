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
        notifications.add(new com.example.models.Notification("Bạn còn 1 tiếng trước buổi học C11 của giảng viên Trần Thoa"));
        notifications.add(new com.example.models.Notification("Bạn còn 1 ngày trước buổi học D11 của giảng viên Nguyễn Minh Minh"));
        notifications.add(new com.example.models.Notification("Tài khoản Premium của bạn đã được update thành công"));
        notifications.add(new com.example.models.Notification("Cảm ơn bạn đã đánh giá giảng viên. Những feedback của bạn sẽ giúp cho team hoạt động tốt hơn"));
        notifications.add(new com.example.models.Notification("Giảng viên Phạm Minh Trọng đã update tài liệu sau buổi học ngày 28/11/2021. Chúc bạn học tập vui vẻ."));
        notifications.add(new com.example.models.Notification("Giảng viên Phạm Long Thuyên đã update tài liệu sau buổi học ngày 1/11/2021. Chúc bạn học tập vui vẻ."));
        notificationAdapter = new NotificationAdapter(this, notifications);
        lvNotification.setAdapter(notificationAdapter);
    }



    private void linkView() {
        lvNotification = findViewById(R.id.lvNotification);
    }
}