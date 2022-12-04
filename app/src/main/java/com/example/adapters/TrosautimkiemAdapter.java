package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moroapplication.R;

import java.util.List;


public class TrosautimkiemAdapter extends BaseAdapter {
    private Context context1;
    private int layout1;
    private List<Trosautimkiem> TrosautimkiemList;


    public TrosautimkiemAdapter(Context context1, int layout1, List<Trosautimkiem> TrosautimkiemList) {
        this.context1 = context1;
        this.layout1 = layout1;
        this.TrosautimkiemList = TrosautimkiemList;
    }


    @Override
    public int getCount() {
        return TrosautimkiemList.size();
    }

    @Override
    public Object getItem(int i) {
        return TrosautimkiemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        LayoutInflater inflater= (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null){
            holder=new ViewHolder();
            view =inflater.inflate(layout1,null);
            holder.txtnametimkiem=view.findViewById(R.id.txt_Nametimkiem);
            holder.txtgiatimkiem=view.findViewById(R.id.txt_giatimkiem);
            holder.imvtimkiem=view.findViewById(R.id.imv_timkiem);
            holder.txtdiachitimkiem=view.findViewById(R.id.txt_diachitimkiem);
            holder.txtdientichtimkiem=view.findViewById(R.id.txt_dientichtimkiem);
            view.setTag(holder);
        }
        else {
            holder= (ViewHolder) view.getTag();

        }

        Trosautimkiem t = TrosautimkiemList.get(i);
        holder.txtnametimkiem.setText(t.getTenSautimkiem());
        holder.imvtimkiem.setImageResource(t.getImageSautimkiem());
        holder.txtdiachitimkiem.setText(t.getDiachiSautimkiem());
        holder.txtgiatimkiem.setText(t.getGiaSautimkiem());
        holder.txtdientichtimkiem.setText(t.getDientichSautimkiem());

    return view;

    }
        public static class ViewHolder {

            TextView txtnametimkiem;
            TextView txtgiatimkiem;
            TextView txtdientichtimkiem;
            ImageView imvtimkiem;
            TextView txtdiachitimkiem;
        }

    }


