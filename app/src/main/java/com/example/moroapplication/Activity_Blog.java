package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.BlogAdapter;
import com.example.models.Blog;
import com.example.moroapplication.databinding.ActivityBlogBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Activity_Blog extends AppCompatActivity {

    ActivityBlogBinding binding;

    TextView txtContent;
    ListView lvBlog;
    ArrayList<Blog> blogList;
    BlogAdapter adapter;
    ImageView imvReact, imvCmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        bottomNav();
        binding = ActivityBlogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
//        selectedbeer();

    }

    private void loadData() {
        blogList = new ArrayList<>();
        blogList.add(new Blog("XEM TUỔI XÂY/LÀM NHÀ", R.drawable.tipsmuanha));
        blogList.add(new Blog("Nên Sơn Nhà Màu Nào Để Bán Được Giá Cao Hơn Hàng Chục, Hàng Trăm Triệu?", R.drawable.sonnha));
        blogList.add(new Blog("Hỏi Gì Cũng Đáp Về BĐS", R.drawable.hoidap));
        blogList.add(new Blog("KINH NGHIỆM MUA BÁN NHÀ", R.drawable.nhachobolg));
        blogList.add(new Blog("5 Lợi Ích Khi Giao Dịch Bất Động Sản Qua Các Website Nhà Đất Uy Tín", R.drawable.loiich));
        blogList.add(new Blog("Mua BĐS ven sông: lợi nhuận tốt", R.drawable.quan2));
        adapter = new BlogAdapter(Activity_Blog.this, R.layout.item_blog,blogList);
        binding.lvBlogsample.setAdapter(adapter);

//        adapter = new BeerAdapter(MainActivity.this, R.layout.activity_beers,beerlist);
//        binding.gvBeers.setAdapter(adapter);


//        beerlist = new ArrayList<>();
//        beerlist.add(new products("Sài Gòn", R.drawable.saigon));
//        beerlist.add(new products("Hà Nội", R.drawable.hanoi));
//        beerlist.add(new products("Tiger", R.drawable.tiger));
//        beerlist.add(new products("Heineken", R.drawable.heineken));
//        beerlist.add(new products("Bia 333", R.drawable.beer333));
//        beerlist.add(new products("Sapporo", R.drawable.sapporo));
//        beerlist.add(new products("Larue", R.drawable.larue));
//        adapter = new BeerAdapter(MainActivity.this, R.layout.activity_beers,beerlist);
//        binding.gvBeers.setAdapter(adapter);
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