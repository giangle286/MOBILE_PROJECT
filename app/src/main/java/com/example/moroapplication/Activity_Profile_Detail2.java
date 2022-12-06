package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.moroapplication.databinding.ActivityProfileDetail2UpdateInfoBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activity_Profile_Detail2 extends AppCompatActivity {
    LinearLayout LayoutSecurity, LayoutChangeInfo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail2);
        View view = getLayoutInflater().inflate(R.layout.activity_profile, null);
        LayoutSecurity = findViewById(R.id.Layout_Security);
        LayoutChangeInfo =findViewById(R.id.Layout_ChangeInfo);
    }
    {
        LayoutSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Profile_Detail2.this, Activity_Profile_Detail2_Update_Password.class);
                startActivity(intent);
            }
        });
        LayoutChangeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Profile_Detail2.this, Activity_Profile_Detail2_Update_Info.class);
                startActivity(intent);
            }
        });
    }
}
