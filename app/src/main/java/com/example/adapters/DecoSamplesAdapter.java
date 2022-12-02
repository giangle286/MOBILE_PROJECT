package com.example.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.models.DecoSamples;
import com.example.moroapplication.Activity_Deco_Details;
import com.example.moroapplication.R;


import java.util.List;

public class DecoSamplesAdapter extends PagerAdapter {
    private List<DecoSamples>mListDecoSamples;

    public DecoSamplesAdapter(List<DecoSamples> mListDecoSamples) {
        this.mListDecoSamples = mListDecoSamples;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=LayoutInflater.from(container.getContext()).inflate(R.layout.activity_itemdecodetail,container,false);
        ImageView imvDecoSamples=view.findViewById(R.id.imv_DecoSamples);
        DecoSamples decoSamples=mListDecoSamples.get(position);
        imvDecoSamples.setImageResource(decoSamples.getResourceID());
        //add view
        container.addView(view);


        return view;
    }

    @Override
    public int getCount() {
        if(mListDecoSamples!=null){
            return mListDecoSamples.size();
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

