package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.adapters.TrohomepageCategoryAdapter;
import com.example.models.Trohomepage;
import com.example.models.TrohomepageCategory;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends AppCompatActivity {
    private RecyclerView rcvhomepageCategory;
    private TrohomepageCategoryAdapter trohomepageCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        rcvhomepageCategory=findViewById(R.id.rcv_homepageCategory);
        trohomepageCategoryAdapter=new TrohomepageCategoryAdapter(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvhomepageCategory.setLayoutManager(linearLayoutManager);
        trohomepageCategoryAdapter.setData((getListTrohomepageCategory()));
        rcvhomepageCategory.setAdapter(trohomepageCategoryAdapter);
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
    private List<TrohomepageCategory> getListTrohomepageCategory() {
        List<TrohomepageCategory> listTrohomepageCategory = new ArrayList<>();
        List<Trohomepage> trohomepageList = new ArrayList<>();
        trohomepageList.add(new Trohomepage(R.drawable.img_nt1, "Phòng trọ Thủ Đức", "20 triệu", "thủ đức"));

        trohomepageList.add(new Trohomepage(R.drawable.img_nt2, "Phòng trọ Thủ Đức", "20 triệu", "Linh Trung, Thủ Đức"));

        trohomepageList.add(new Trohomepage(R.drawable.img_nt3, "Phòng trọ Thủ Đức", "20 triệu", "Linh Xuân, Thủ Đức"));

        listTrohomepageCategory.add(new TrohomepageCategory("Tìm người ở ghép",trohomepageList));
        listTrohomepageCategory.add(new TrohomepageCategory("Tìm phòng trọ",trohomepageList));
        listTrohomepageCategory.add(new TrohomepageCategory("Tìm nhà cho thuê",trohomepageList));
        return  listTrohomepageCategory;

    }
}