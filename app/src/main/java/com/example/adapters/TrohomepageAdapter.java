package com.example.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Trohomepage;
import com.example.moroapplication.R;

import java.util.List;


public class TrohomepageAdapter extends RecyclerView.Adapter<TrohomepageAdapter.TrohomepageViewHolder>{
    private List<Trohomepage> trohomepages;
    public void setData(List<Trohomepage>list){
        this.trohomepages=list;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public TrohomepageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_itemnhatro,parent,false);

        return new TrohomepageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrohomepageViewHolder holder, int position) {
        Trohomepage trohomepage=trohomepages.get(position);
        if(trohomepage==null){
            return;
        }
        holder.imgNhatrohomepage.setImageResource(trohomepage.getResourceId());
        holder.txtNameHomepage.setText(trohomepage.getTxt_NameHomepage());
        holder.txtgiaphongtro.setText(trohomepage.getTxt_giaphongtro());
        holder.txtdiachiphongtro.setText(trohomepage.getTxt_diachiphongtro());
    }

    @Override
    public int getItemCount() {
        if(trohomepages!=null){
            return trohomepages.size();
        }
        return 0;
    }

    public class TrohomepageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgNhatrohomepage;
        private TextView txtNameHomepage;
        private TextView txtgiaphongtro;
        private TextView txtdiachiphongtro;


        public TrohomepageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNhatrohomepage=itemView.findViewById(R.id.img_Nhatrohomepage);
            txtNameHomepage=itemView.findViewById(R.id.txt_NameHomepage);
            txtgiaphongtro=itemView.findViewById(R.id.txt_giaphongtro);
            txtdiachiphongtro=itemView.findViewById(R.id.txt_diachiphongtro);

        }
    }

}