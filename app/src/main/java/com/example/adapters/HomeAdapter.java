package com.example.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Home;
import com.example.moroapplication.Activity_Room_Details;
import com.example.moroapplication.R;
import com.example.moroapplication.activity_rental_details;

import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private Context mContext;
    private List<Home> mListHome;

    public HomeAdapter(Context mContext, List<Home> mListHome) {

        this.mContext = mContext;
    }
    public void setData(List<Home>list){
        this.mListHome=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_nhatrosample1,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Home home=mListHome.get(position);
        if(home==null){
            return;
        }
        holder.imgtro.setImageResource(home.getImgtro());

        holder.txtgiatro.setText(home.getTxtgiatro());
        holder.txtdientichtro.setText(home.getTxtdientichtro());
        holder.txtdiachitro.setText(home.getTxtdiachitro());
        holder.layout_itemhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToRentalDetails(home);
            }
        });

    }
    private void onClickGoToRentalDetails(Home home) {
        Intent intent=new Intent(mContext, activity_rental_details.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object_home",home);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mListHome!=null){
            return mListHome.size();
        }
        return 0;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout layout_itemhome;
        ImageView imgtro;
        private TextView txtgiatro;
        private TextView txtdientichtro;
        private TextView txtdiachitro;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_itemhome=itemView.findViewById(R.id.layout_itemhome);
            imgtro=itemView.findViewById(R.id.img_tro);
            txtgiatro=itemView.findViewById(R.id.txt_giatro);
            txtdientichtro=itemView.findViewById(R.id.txt_dientichtro);
            txtdiachitro=itemView.findViewById(R.id.txt_diachitro);

        }
    }

}