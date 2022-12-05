package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        binding = ActivityBlogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        bottomNav();
        selectedBlog();

    }

    private void selectedBlog() {
        binding.lvBlogsample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(Activity_Blog.this,Activity_Blog_Details.class);
                Blog b = blogList.get(i);
                intent.putExtra("selectimage", b.getImageBlog());
                intent.putExtra("selecttitle",b.getTitleBlog());
                intent.putExtra("selectime",b.getTimeBlog());
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


    private void loadData() {
        blogList = new ArrayList<>();
        blogList.add(new Blog("XEM TUỔI XÂY/LÀM NHÀ", R.drawable.tipsmuanha, "30 phút trước"));
        blogList.add(new Blog("Nên Sơn Nhà Màu Nào Để Bán Được Giá Cao Hơn Hàng Chục, Hàng Trăm Triệu?", R.drawable.sonnha, "1 giờ trước"));
        blogList.add(new Blog("Hỏi Gì Cũng Đáp Về BĐS", R.drawable.hoidap, "9 giờ trước"));
        blogList.add(new Blog("KINH NGHIỆM MUA BÁN NHÀ", R.drawable.nhachobolg, "1 ngày trước"));
        blogList.add(new Blog("5 Lợi Ích Khi Giao Dịch Bất Động Sản Qua Các Website Nhà Đất Uy Tín", R.drawable.loiich, "2 ngày trước"));
        blogList.add(new Blog("Mua BĐS ven sông: lợi nhuận tốt", R.drawable.quan2,"1 tuần trước"));
        adapter = new BlogAdapter(Activity_Blog.this, R.layout.item_blog,blogList);
        binding.lvBlogsample.setAdapter(adapter);

//
    }


}