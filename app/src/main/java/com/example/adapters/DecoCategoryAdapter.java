package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interfaces.IClickItemDecoListener;
import com.example.models.Deco;
import com.example.models.DecoCategory;
import com.example.moroapplication.R;

import java.util.List;
import java.util.Locale;

public class DecoCategoryAdapter extends RecyclerView.Adapter<DecoCategoryAdapter.CategoryViewHolder>  {
    private Context mContext;
    private List<DecoCategory>mlistDecoCategory;


    public DecoCategoryAdapter (Context mContext )
    {
        this.mContext = mContext;
    }
    public void setData(List<DecoCategory>list){
        this.mlistDecoCategory=list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categorydeco,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        DecoCategory decoCategory = mlistDecoCategory.get(position);
        if (decoCategory == null) {
            return;
        }
        holder.txtNameCategory.setText(decoCategory.getNameCategory());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcvDeco.setLayoutManager(linearLayoutManager);
        DecoAdapter decoAdapter=new DecoAdapter();
        decoAdapter.setData(decoCategory.getDeco());
        holder.rcvDeco.setAdapter(decoAdapter);

    }

    @Override
    public int getItemCount() {
        if(mlistDecoCategory!=null){
            return mlistDecoCategory.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNameCategory;
        private RecyclerView rcvDeco;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameCategory=itemView.findViewById(R.id.txt_name_category);
            rcvDeco=itemView.findViewById(R.id.rcv_deco);


        }
    }
}
