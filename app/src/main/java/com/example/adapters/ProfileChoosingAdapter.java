package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.models.ProfileChoosing;
import com.example.moroapplication.R;

import java.util.List;

public class ProfileChoosingAdapter extends BaseAdapter {
        private Context context;
        private int item_layout;
        private List<ProfileChoosing> ListProfileChoosing;

        public ProfileChoosingAdapter(Context context, int item_layout, List<ProfileChoosing> ListProfileChoosing) {
            this.context = context;
            this.item_layout = item_layout;
            this.ListProfileChoosing = ListProfileChoosing;
        }

    public List<ProfileChoosing> getListProfileChoosing() {
        return ListProfileChoosing;
    }

    public void setListProfileChoosing(List<ProfileChoosing> listProfileChoosing) {
        ListProfileChoosing = listProfileChoosing;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            com.example.adapters.ProfileChoosingAdapter.ViewHolder holder;
            if (view==null){
                holder= new com.example.adapters.ProfileChoosingAdapter.ViewHolder();
                LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=inflater.inflate(item_layout,null);
                holder.txt_ContentCmt=view.findViewById(R.id.txt_ContentCmt);
                view.setTag(holder);
            }else{
                holder=(com.example.adapters.ProfileChoosingAdapter.ViewHolder) view.getTag();
            }

            ProfileChoosing c=ListProfileChoosing.get(i);
            holder.txt_ContentCmt.setText(c.getProfileTitle());
            return view;
        }

        public static class ViewHolder{

            TextView txt_ContentCmt;


        }
    }


