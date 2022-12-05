package com.example.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Shareroom;
import com.example.moroapplication.R;

import java.util.List;

public class ShareroomAdapter extends RecyclerView.Adapter<ShareroomAdapter.ShareroomViewHolder> {
    private List<Shareroom> sharerooms;

    public void setData(List<Shareroom> list) {
        this.sharerooms = list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ShareroomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_shareroom_itemshareroom, parent, false);

        return new ShareroomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShareroomViewHolder holder, int position) {
        Shareroom shareroom = sharerooms.get(position);
        if (shareroom == null) {
            return;
        }
        holder.imgShareroom.setImageResource(shareroom.getResourceId());
        holder.imgShareroom.setImageResource(shareroom.getResourceId1());
        holder.giaShareroom.setText(shareroom.getGiaShareroom());
        holder.diachiShareroom.setText(shareroom.getDiachiShareroom());
        holder.dientichShareroom.setText(shareroom.getDientichShareroom());
        holder.tenShareroom.setText(shareroom.getTenShareroom());
    }

    @Override
    public int getItemCount() {
        if (sharerooms != null) {
            return sharerooms.size();
        }
        return 0;
    }

    public class ShareroomViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgShareroom;
        private ImageView imgShareroomicon;
        private TextView giaShareroom;
        private TextView diachiShareroom;
        private TextView  tenShareroom;
        private TextView dientichShareroom;


        public ShareroomViewHolder(@NonNull View itemView) {
            super(itemView);
            imgShareroom = itemView.findViewById(R.id.img_Shareroom);
            imgShareroomicon = itemView.findViewById(R.id.img_sr_diachi);
            giaShareroom = itemView.findViewById(R.id.txt_sr_gia);
            diachiShareroom = itemView.findViewById(R.id.txt_sr_diach);
            dientichShareroom = itemView.findViewById(R.id.txt_sr_dientich);
            tenShareroom = itemView.findViewById(R.id.txt_sr_tenshareroom);
        }
    }
}

//Shareroom



