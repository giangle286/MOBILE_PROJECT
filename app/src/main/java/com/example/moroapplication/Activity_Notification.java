package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Activity_Notification extends AppCompatActivity {

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
        notifications.add(new com.example.models.Notification(R.drawable.ngoc,"Mỹ Lệ Trần thích bài viết của bạn"));
        notifications.add(new com.example.models.Notification(R.drawable.ic_baseline_upload_24,"Bạn vừa tải lên một bài viết"));
        notifications.add(new com.example.models.Notification(R.drawable.ngocchau,"Hoa hậu Ngọc Châu và 3 người khác đã thích bài viết của bạn"));notifications.add(new com.example.models.Notification(R.drawable.ic_baseline_message_24,"Mai Mai đã gửi một tin nhắn đến Nhóm nhà trọ 777"));notifications.add(new com.example.models.Notification(R.drawable.animegirl,"Lý Lệ Tuyền đã thích bài viết của bạn"));notifications.add(new com.example.models.Notification(R.drawable.girl,"O Sen đã bình luận bài viết của bạn"));notifications.add(new com.example.models.Notification(R.drawable.ic_baseline_update_24,"Thời hạn gói dịch vụ của bạn còn 5 ngày nữa"));


//        notifications.add(new com.example.models.Notification());
//        notifications.add(new com.example.models.Notification(""));
//        notifications.add(new com.example.models.Notification(""));
//        notifications.add(new com.example.models.Notification(""));
//        notifications.add(new com.example.models.Notification(""));
        notificationAdapter = new NotificationAdapter(Activity_Notification.this,notifications);
        lvNotification.setAdapter(notificationAdapter);
    }

    private void linkView() {
        lvNotification = findViewById(R.id.lvNotification);

    }
}