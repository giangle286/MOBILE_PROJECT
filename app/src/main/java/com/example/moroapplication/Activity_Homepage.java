package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import com.example.adapters.BannerAdapter;
import com.example.adapters.DecorAdapter;
import com.example.adapters.MotelRoomAdapter;
import com.example.models.Banner;
import com.example.models.Decor;
import com.example.models.MotelRoom;


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

                // tạo Dialog dialog_service

                Intent intent = new Intent(Activity_Homepage.this, Activity_MotelRoom.class);
                startActivity(intent);
            }
        });

    }

    private List<MotelRoom> getListMotelRoom() {
        List<MotelRoom> list = new ArrayList<>();
        list.add(new MotelRoom(MotelRoom.TYPE_TINNOIBATMOTELROOM, "Phòng trọ 1", "1000000", "Hà Nội", "100m2",3.0,"2.500.000","Sàn xịn mịn",R.drawable.img_nt1));
        list.add(new MotelRoom(MotelRoom.TYPE_TINNOIBATMOTELROOM, "Phòng trọ 1", "1000000", "Hà Nội", "100m2",3.0,"2.500.000","Sàn xịn mịn",R.drawable.img_nt2));
        list.add(new MotelRoom(MotelRoom.TYPE_TINNOIBATMOTELROOM, "Phòng trọ 1", "1000000", "Hà Nội", "100m2",3.0,"2.500.000","Sàn xịn mịn",R.drawable.img_nt3));


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
