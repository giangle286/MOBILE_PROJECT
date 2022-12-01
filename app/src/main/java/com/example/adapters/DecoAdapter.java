package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Deco;
import com.example.models.DecoSamples;
import com.example.moroapplication.Activity_Deco;
import com.example.moroapplication.R;

import java.util.List;

public class DecoAdapter extends RecyclerView.Adapter<DecoAdapter.DecoViewHolder>{
    private List<Deco> decos;
    public void setData(List<Deco>list){
        this.decos=list;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public DecoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_itemdeco,parent,false);

        return new DecoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DecoViewHolder holder, int position) {
        Deco deco=decos.get(position);
        if(deco==null){
            return;
        }
        holder.imgDeco.setImageResource(deco.getResourceId());
        holder.txtNameDeco.setText(deco.getNameDeco());
        holder.txtUserDeco.setText(deco.getUserDeco());
        holder.txtTimeDeco.setText(deco.getTimeDeco());


    }

    @Override
    public int getItemCount() {
        if(decos!=null){
            return decos.size();
        }
        return 0;
    }

    public class DecoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgDeco;
        private TextView txtNameDeco;
        private TextView txtUserDeco;
        private TextView txtTimeDeco;





        public DecoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDeco=itemView.findViewById(R.id.img_Deco);
            txtNameDeco=itemView.findViewById(R.id.txt_NameDeco);
            txtUserDeco=itemView.findViewById(R.id.txt_UserDeco);
            txtTimeDeco=itemView.findViewById(R.id.txt_TimeDeco);

        }
    }

    }





