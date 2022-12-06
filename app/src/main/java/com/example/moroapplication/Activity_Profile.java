package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.adapters.DecoCategoryAdapter;
import com.example.adapters.ProfileChoosingAdapter;
import com.example.models.Blog;
import com.example.models.ProfileChoosing;
import com.example.moroapplication.databinding.ActivityProfileBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Profile extends AppCompatActivity {
    //View view = getLayoutInflater().inflate(R.layout.activity_profile, null);
    LinearLayout LayoutAccountManagement, LayoutSaved, LayoutReport, LayoutLogout, LayoutPolicy;
    ImageButton imbPolicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       View view= getLayoutInflater().inflate(R.layout.activity_profile, null);
        LayoutAccountManagement=findViewById(R.id.Layout_AccountManagement);
        LayoutPolicy=findViewById(R.id.Layout_Policy);
        LayoutLogout= findViewById(R.id.Layout_Logout);
        LayoutReport= findViewById(R.id.Layout_Report);
        LayoutSaved= findViewById(R.id.Layout_Saved);
        imbPolicy = findViewById(R.id.imbGoPolicy);
        bottomNav();
        //addEvents();

        imbPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Profile.this, Activity_Profile_Detail5.class);
                startActivity(intent);
            }
        });
        LayoutAccountManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Activity_Profile.this,Activity_Profile_Detail2.class);
                startActivity(intent);
            }
        });
        //click vào layout policy
        LayoutPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Activity_Profile.this,Activity_Profile_Detail5.class);
                startActivity(intent);
            }
        });
        LayoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Activity_Profile.this,Activity_Profile_Detail4_Logout.class);
                startActivity(intent);
            }
        });
        LayoutReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Activity_Profile.this,Activity_Profile_Detail6.class);
                startActivity(intent);
            }
        });
        LayoutSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Activity_Profile.this,Activity_Profile_Detail3.class);
                startActivity(intent);
            }
        });
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

    }
