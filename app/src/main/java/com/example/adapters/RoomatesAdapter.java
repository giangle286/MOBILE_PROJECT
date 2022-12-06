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

import com.example.models.Roomates;
import com.example.moroapplication.Activity_Roomates_Details;
import com.example.moroapplication.R;

import java.io.Serializable;
import java.util.List;

public class RoomatesAdapter extends RecyclerView.Adapter<RoomatesAdapter.RoomatesViewHolder> {
    private Context mContext;
    private List<Roomates> mListRoomates;

    public RoomatesAdapter(Context mContext, List<Roomates> mListRoomates) {

        this.mContext = mContext;
    }
    public void setData(List<Roomates>list){
        this.mListRoomates=list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RoomatesAdapter.RoomatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_itemroomates,parent,false);
        return new RoomatesAdapter.RoomatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomatesAdapter.RoomatesViewHolder holder, int position) {
        Roomates roomates=mListRoomates.get(position);
        if(roomates==null){
            return;
        }
        holder.txt_TitleRoomates.setText(roomates.getTitleRoomates());
        holder.txtAddressRoomates.setText(roomates.getAddressRoomates());
        holder.txtSquareRoomates.setText(roomates.getSquareRoomates());
        holder.imgRoomates.setImageResource(roomates.getResourceImage());
        holder.layout_itemroomates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToRoomatesDetails(roomates);
            }
        });

    }
    private void onClickGoToRoomatesDetails(Roomates roomates) {
        Intent intent=new Intent(mContext, Activity_Roomates_Details.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object_roomates", (Serializable) roomates);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        if(mListRoomates!=null){
            return mListRoomates.size();
        }
        return 0;
    }

    public class RoomatesViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout layout_itemroomates;
        private  TextView txt_TitleRoomates;
//        private TextView txtNameRoomates;
//        private TextView txtPhoneRoomates;
        private TextView txtAddressRoomates;
        private TextView txtSquareRoomates;
//        private TextView txtNobRoomates;
        private TextView txtGenderRoomates;
//        private TextView txDescribeRoomates;
        private ImageView imgRoomates;



        public RoomatesViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_itemroomates=itemView.findViewById(R.id.layout_itemroomates);
            txt_TitleRoomates=itemView.findViewById(R.id.txt_TitleRoomates);
            txtAddressRoomates=itemView.findViewById(R.id.txt_AddressRoomates);
            txtSquareRoomates=itemView.findViewById(R.id.txt_SquareRoomates);
            imgRoomates=itemView.findViewById(R.id.img_Roomates);


        }
    }

}
