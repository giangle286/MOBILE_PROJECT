package com.example.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.models.DecoSamples;
import com.example.moroapplication.Activity_Deco_Details;
import com.example.moroapplication.R;

import java.util.List;

public class DecoSamplesAdapter extends BaseAdapter {
    Activity_Deco_Details activity_deco_details;
    int item_layout;
    List<DecoSamples> decoSamples;

    public DecoSamplesAdapter(Activity_Deco_Details activity_deco_details, int item_layout, List<DecoSamples> decoSamples) {
        this.activity_deco_details = activity_deco_details;
        this.item_layout = item_layout;
        this.decoSamples = decoSamples;
    }

    @Override
    public int getCount() {
        return decoSamples.size();
    }

    @Override
    public Object getItem(int i) {
        return decoSamples.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        get view: liên kết ánh xạ view để đổ dữ liệu lên
        // link view and binding data
        ViewHolder holder;
        if(view==null){
//            Link views
            holder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) activity_deco_details.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(item_layout, null);
            holder.imvDecoSamples = view.findViewById(R.id.imv_DecoSamples);

//            holder. = view.findViewById(R.id.imvThumb);

            view.setTag(holder);

        }else{
            holder=(ViewHolder) view.getTag();

        }
//        binding data
        DecoSamples d =decoSamples.get(i);
        holder.imvDecoSamples.setImageResource(d.getDecoSamples());
        return view;
    }
    public static class ViewHolder{
        ImageView imvDecoSamples;


    }




}
