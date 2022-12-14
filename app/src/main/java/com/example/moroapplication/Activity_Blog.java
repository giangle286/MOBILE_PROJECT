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
                        startActivity(new Intent(getApplicationContext(),Activity_Homepage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_news:

                        return true;
                    case R.id.action_decor:
                        startActivity(new Intent(getApplicationContext(),Activity_Decor.class));
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


    private void loadData() {
        blogList = new ArrayList<>();
        blogList.add(new Blog("XEM TU???I X??Y/L??M NH??", R.drawable.tipsmuanha, "30 ph??t tr?????c"));
        blogList.add(new Blog("N??n S??n Nha?? Ma??u Na??o ?????? Ba??n ????????c Gia?? Cao H??n Ha??ng Chu??c, Ha??ng Tr??m Tri????u?", R.drawable.sonnha, "1 gi??? tr?????c"));
        blogList.add(new Blog("H???i G?? C??ng ????p V??? B??S", R.drawable.hoidap, "9 gi??? tr?????c"));
        blogList.add(new Blog("KINH NGHI???M MUA B??N NH??", R.drawable.nhachobolg, "1 ng??y tr?????c"));
        blogList.add(new Blog("5 L???i ??ch Khi Giao D???ch B???t ?????ng S???n Qua C??c Website Nh?? ?????t Uy T??n", R.drawable.loiich, "2 ng??y tr?????c"));
        blogList.add(new Blog("Mua B??S ven s??ng: l???i nhu???n t???t", R.drawable.quan2,"1 tu???n tr?????c"));
        adapter = new BlogAdapter(Activity_Blog.this, R.layout.item_blog,blogList);
        binding.lvBlogsample.setAdapter(adapter);

//
    }


}