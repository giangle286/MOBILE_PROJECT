package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.models.Deco;
import com.example.models.DecoSamples;
import com.example.moroapplication.Activity_Deco;
import com.example.moroapplication.R;

import java.util.List;

public class DecoAdapter extends BaseAdapter {
    Activity_Deco activity_deco;
    int item_layout;
    List<Deco>deco;

    public DecoAdapter(Activity_Deco activity_deco, int item_layout, List<Deco> deco) {
        this.activity_deco = activity_deco;
        this.item_layout = item_layout;
        this.deco = deco;
    }

    @Override
    public int getCount() {
        return deco.size();
    }

    @Override
    public Object getItem(int i) {
        return deco.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        get view: liên kết ánh xạ view để đổ dữ liệu lên
        // link view and binding data
        DecoSamplesAdapter.ViewHolder holder;
        if(view==null){
//            Link views
            holder=new DecoSamplesAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) activity_deco.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(item_layout, null);
            holder.imvDecoSamples = view.findViewById(R.id.imb_ThumbDeco);

//            holder. = view.findViewById(R.id.imvThumb);

            view.setTag(holder);

        }else{
            holder=(DecoSamplesAdapter.ViewHolder) view.getTag();

        }
//        binding data
        Deco de =deco.get(i);
        holder.imvDecoSamples.setImageResource(de.getThumbDeco());
        return view;
    }
    public static class ViewHolder{
        ImageButton imb_ThumbDeco;


    }




}
