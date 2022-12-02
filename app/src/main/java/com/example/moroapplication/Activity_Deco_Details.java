package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.example.adapters.DecoSamplesAdapter;
import com.example.models.DecoSamples;
import com.example.moroapplication.databinding.ActivityDecoDetailsBinding;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Activity_Deco_Details extends AppCompatActivity {
    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicator;
    private List<DecoSamples>mListDecoSamples;

    private Handler mHandler=new Handler();
    private Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            if(mViewPager.getCurrentItem()==mListDecoSamples.size()-1){
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
        setContentView(R.layout.activity_deco_details);
        mViewPager=findViewById(R.id.deco_viewpager);
        mCircleIndicator=findViewById(R.id.deco_circle_indicator);
        mListDecoSamples=getListDecoSamples();
        DecoSamplesAdapter adapter=new DecoSamplesAdapter(mListDecoSamples);
        mViewPager.setAdapter(adapter);
        mCircleIndicator.setViewPager(mViewPager);
        mHandler.postDelayed(mRunnable,4000);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable,5000);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private List<DecoSamples> getListDecoSamples(){
        List<DecoSamples>list=new ArrayList<>();
        list.add(new DecoSamples(R.drawable.deco_detail1));
        list.add(new DecoSamples(R.drawable.deco_detail2));
        list.add(new DecoSamples(R.drawable.deco_detail3));
        list.add(new DecoSamples(R.drawable.deco_detail1));



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