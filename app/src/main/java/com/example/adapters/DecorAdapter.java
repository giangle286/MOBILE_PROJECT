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
import androidx.viewpager.widget.ViewPager;

import com.example.models.Decor;
import com.example.moroapplication.Activity_Decor_Details;
import com.example.moroapplication.R;

import java.util.List;

public class DecorAdapter extends RecyclerView.Adapter<DecorAdapter.DecorViewHolder> {
    private Context mContext;
    private List<Decor> mListDecor;

    public DecorAdapter(Context mContext, List<Decor> mListDecor) {

        this.mContext = mContext;
    }
    public void setData(List<Decor>list){
        this.mListDecor=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DecorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_itemdecor,parent,false);
        return new DecorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DecorViewHolder holder, int position) {
        Decor decor=mListDecor.get(position);
        if(decor==null){
            return;
        }
        holder.imgDecor.setImageResource(decor.getResourceImage());
        holder.txtNameDecor.setText(decor.getNameDecor());
        holder.txtUserDecor.setText(decor.getUserDecor());
        holder.txtTimeDecor.setText(decor.getTimeDecor());
        holder.layout_itemdecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToDecoDetails(decor);
            }
        });

    }
    private void onClickGoToDecoDetails(Decor decor) {
        Intent intent=new Intent(mContext, Activity_Decor_Details.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object_decor",decor);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mListDecor!=null){
            return mListDecor.size();
        }
        return 0;
    }

    public class DecorViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout layout_itemdecor;
        private ImageView imgDecor;
        private TextView txtNameDecor;
        private TextView txtUserDecor;
        private TextView txtTimeDecor;

        public DecorViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_itemdecor=itemView.findViewById(R.id.layout_itemdecor);
            imgDecor=itemView.findViewById(R.id.img_Decor);
            txtNameDecor=itemView.findViewById(R.id.txt_NameDecor);
            txtUserDecor=itemView.findViewById(R.id.txt_UserDecor);
            txtTimeDecor=itemView.findViewById(R.id.txt_TimeDecor);

        }
    }

}
