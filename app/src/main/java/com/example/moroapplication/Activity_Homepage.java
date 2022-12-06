package com.example.moroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.adapters.BannerAdapter;
import com.example.adapters.DecorAdapter;
import com.example.adapters.MotelRoomAdapter;
import com.example.models.Banner;
import com.example.models.Decor;
import com.example.models.MotelRoom;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Activity_Homepage extends AppCompatActivity {
    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicator;
    private List<Banner> mListBanner;
    private RecyclerView rcv_homepage;
    private MotelRoomAdapter mMotelRoomAdapter;
    private GridLayoutManager gridLayoutManager;
    private ImageButton imbFilter;

    ImageButton btn_FindRoom, btn_FindRoomMate, btn_Post;

    private Handler mHandler=new Handler();
    private Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            if(mViewPager.getCurrentItem()==mListBanner.size()-1){
                mViewPager.setCurrentItem(0);
            }else{
                mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
            }
            mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        imbFilter=findViewById(R.id.imb_Filter);
        bottomNav();

        imbFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Homepage.this, activity_filter2.class);
                startActivity(intent);
            }
        });

        rcv_homepage = findViewById(R.id.rcv_homepage);
        mMotelRoomAdapter = new MotelRoomAdapter(this, getListMotelRoom());

        btn_FindRoom = findViewById(R.id.btn_FindRoom);
        btn_FindRoomMate = findViewById(R.id.btn_FindRoomMate);
        btn_Post = findViewById(R.id.btn_Post);

        gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        rcv_homepage.setLayoutManager(gridLayoutManager);
        mMotelRoomAdapter.setData(getListMotelRoom());
        rcv_homepage.setAdapter(mMotelRoomAdapter);

        mViewPager=findViewById(R.id.homepage_viewpager);
        mCircleIndicator=findViewById(R.id.homepage_circle_indicator);
        mListBanner=getListBanner();
        BannerAdapter adapter=new BannerAdapter(mListBanner);
        mViewPager.setAdapter(adapter);
        mCircleIndicator.setViewPager(mViewPager);
        mHandler.postDelayed(mRunnable,2000);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable,3000);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        addEvents();
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

    private void addEvents() {

        btn_FindRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Homepage.this, Activity_MotelRoom.class);
                startActivity(intent);
            }
        });

        btn_FindRoomMate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Homepage.this, Activity_Roomates.class);
                startActivity(intent);
            }
        });

        btn_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // tạo dialog
                Dialog dialog = new Dialog(Activity_Homepage.this);
                dialog.setContentView(R.layout.dialog_service);
                dialog.show();

                // ánh xạ
                Button btnRentPost = dialog.findViewById(R.id.btnRentPost);
                Button btnRoommatePost = dialog.findViewById(R.id.btnRoomMatePost);

                // sự kiện
                btnRentPost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Activity_Homepage.this, Activity_Post_Rent.class);
                        startActivity(intent);
                    }
                });

                btnRoommatePost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Activity_Homepage.this, Activity_Post_Roomate.class);
                        startActivity(intent);
                    }
                });

            }
        });

    }

    private List<MotelRoom> getListMotelRoom() {
        List<MotelRoom> list = new ArrayList<>();
        list.add(new MotelRoom(MotelRoom.TYPE_TINNOIBATMOTELROOM,"Phòng cho thuê quận 11", "Phòng trọ 1", "1000000", "Hà Nội", "100m2",3.0,"2.500.000","Sàn xịn mịn",R.drawable.img_nt1));
        list.add(new MotelRoom(MotelRoom.TYPE_TINMOINHATMOTELROOM, "Phòng cho thuê quận 11","Phòng trọ 1", "1000000", "Hà Nội", "100m2",3.0,"2.500.000","Sàn xịn mịn",R.drawable.img_nt2));
        list.add(new MotelRoom(MotelRoom.TYPE_TINNOIBATMOTELROOM,"Phòng cho thuê quận 11", "Phòng trọ 1", "1000000", "Hà Nội", "100m2",3.0,"2.500.000","Sàn xịn mịn",R.drawable.img_nt3));
        list.add(new MotelRoom(MotelRoom.TYPE_TINMOINHATMOTELROOM,"Phòng cho thuê quận 11", "Phòng trọ 1", "1000000", "Hà Nội", "100m2",3.0,"2.500.000","Sàn xịn mịn",R.drawable.img_nt4));




        return list;
    }



    private List<Banner> getListBanner(){
        List<Banner>list=new ArrayList<>();
        list.add(new Banner(R.drawable.banner1));
        list.add(new Banner(R.drawable.banner2));
        list.add(new Banner(R.drawable.banner3));
        list.add(new Banner(R.drawable.banner4));



        return list;

    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable,3000);
    }

}
