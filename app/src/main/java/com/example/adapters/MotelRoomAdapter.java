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

import com.example.models.MotelRoom;
import com.example.models.Roomates;
import com.example.moroapplication.Activity_MotelRoom_Details;
import com.example.moroapplication.R;

import java.io.Serializable;
import java.util.List;

public class MotelRoomAdapter extends RecyclerView.Adapter<MotelRoomAdapter.MotelRoomViewHolder> {
    private Context mContext;
    private List<MotelRoom> mListMotelRoom;

    public MotelRoomAdapter(Context mContext, List<MotelRoom> mListMotelRoom) {

        this.mContext = mContext;
    }
    public void setData(List<MotelRoom>list){
        this.mListMotelRoom=list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MotelRoomAdapter.MotelRoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_motelroom,parent,false);
        return new MotelRoomAdapter.MotelRoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MotelRoomAdapter.MotelRoomViewHolder holder, int position) {
        MotelRoom motelRoom=mListMotelRoom.get(position);
        if(motelRoom==null){
            return;
        }
        holder.txt_TitleMotelRoom.setText(motelRoom.getTypeMotelRoom()+","+motelRoom.getNobMotelRoom()+","+motelRoom.getPriceMotelRoom()+","+motelRoom.getAddressMotelRoom());
        holder.txtPriceMotelRoom.setText(motelRoom.getPriceMotelRoom());
        holder.txtAddressMotelRoom.setText(motelRoom.getAddressMotelRoom());
        holder.txtSquareMotelRoom.setText(motelRoom.getSquareMotelRoom());
        holder.imgMotelRoom.setImageResource(motelRoom.getResourceImage());
        holder.layout_itemMotelRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToMotelRoomDetails(motelRoom);
            }
        });

    }
    private void onClickGoToMotelRoomDetails(MotelRoom motelroom) {
        Intent intent=new Intent(mContext, Activity_MotelRoom_Details.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object_motelroom", (Serializable) motelroom);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        if(mListMotelRoom!=null){
            return mListMotelRoom.size();
        }
        return 0;
    }

    public class MotelRoomViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout layout_itemMotelRoom;
        private TextView txt_TitleMotelRoom;
        //        private TextView txtNameMotelRoom;
//        private TextView txtPhoneMotelRoom;
        private TextView txtAddressMotelRoom;
        private TextView txtSquareMotelRoom;
        //        private TextView txtNobMotelRoom;
        private TextView txtPriceMotelRoom;
        //        private TextView txDescribeMotelRoom;
        private ImageView imgMotelRoom;



        public MotelRoomViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_itemMotelRoom=itemView.findViewById(R.id.layout_itemmotelroom);
            txt_TitleMotelRoom=itemView.findViewById(R.id.txt_TitleMotelRoom);
            txtAddressMotelRoom=itemView.findViewById(R.id.txt_AddressMotelRoom);
            txtSquareMotelRoom=itemView.findViewById(R.id.txt_SquareMotelRoom);
            txtPriceMotelRoom=itemView.findViewById(R.id.txt_PriceMotelRoom);
            imgMotelRoom=itemView.findViewById(R.id.img_MotelRoom);



        }
    }

}


