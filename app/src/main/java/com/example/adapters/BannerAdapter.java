package com.example.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.models.Banner;
import com.example.moroapplication.R;

import java.util.List;

public class BannerAdapter extends PagerAdapter {
    private List<Banner> mListBannner;

    public BannerAdapter(List<Banner> mListBanner) {
        this.mListBannner = mListBanner;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.activity_itemhomepage,container,false);
        ImageView imvBanner=view.findViewById(R.id.imv_Banner);
        Banner banner=mListBannner.get(position);
        imvBanner.setImageResource(banner.getResourceID());
        //add view
        container.addView(view);


        return view;
    }

    @Override
    public int getCount() {
        if(mListBannner!=null){
            return mListBannner.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}



