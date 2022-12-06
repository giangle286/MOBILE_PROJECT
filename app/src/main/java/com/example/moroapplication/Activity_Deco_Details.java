package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.DecoCommentAdapter;
import com.example.adapters.DecoSamplesAdapter;
import com.example.models.Deco;
import com.example.models.DecoComment;
import com.example.models.DecoSamples;
import com.example.moroapplication.databinding.ActivityDecoDetailsBinding;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Activity_Deco_Details extends AppCompatActivity {
    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicator;
    private List<DecoSamples>mListDecoSamples;

    private EditText edtCmt;
    private ImageView imvSendCmt;
    ListView lvCmt;
    DecoCommentAdapter decoCommentAdapter;
    ArrayList<DecoComment> decoComment;

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
        linkView();
        addEvent();
        initAdapter();
//        initData();

        mViewPager=findViewById(R.id.deco_viewpager);
        mCircleIndicator=findViewById(R.id.deco_circle_indicator);
        mListDecoSamples=getListDecoSamples();
        DecoSamplesAdapter adapter=new DecoSamplesAdapter(mListDecoSamples);
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
    }
    private List<DecoSamples> getListDecoSamples(){
        List<DecoSamples>list=new ArrayList<>();
        list.add(new DecoSamples(R.drawable.deco_detail1));
        list.add(new DecoSamples(R.drawable.deco_detail2));
        list.add(new DecoSamples(R.drawable.deco_detail3));
        list.add(new DecoSamples(R.drawable.deco_detail4));



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

    private void linkView() {
        //edtCmt=findViewById(R.id.edt_cmt);
        imvSendCmt=findViewById(R.id.imv_SendCmt);
        lvCmt=findViewById(R.id.lvCmt);
    }

//    private void initData() {
//        decoComment=new ArrayList<>();
//        decoComment.add(new DecoComment("Rất xinh đẹp tuyệt vời","Linh Anh"));
//        decoComment.add(new DecoComment("Xịn quá ạ","Khánh Ngân"));
//        decoCommentAdapter=new DecoCommentAdapter(Activity_Deco_Details.this,R.layout.item_cmt,decoComment);
//        lvCmt.setAdapter(decoCommentAdapter);
//    }

    private void addEvent() {
        imvSendCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                comment=new ArrayList<>();
                decoComment.add(new DecoComment(edtCmt.getText().toString(),"Tiểu Vy"));
                decoCommentAdapter=new DecoCommentAdapter(Activity_Deco_Details.this,R.layout.item_cmt,decoComment);
                lvCmt.setAdapter(decoCommentAdapter);
            }
        });
    }

    private void initAdapter() {

    }
}