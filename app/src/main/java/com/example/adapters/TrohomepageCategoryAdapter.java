package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.TrohomepageCategory;
import com.example.moroapplication.R;

import java.util.List;

public class TrohomepageCategoryAdapter extends RecyclerView.Adapter<TrohomepageCategoryAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<TrohomepageCategory> mlistTrohomepageCategory;

    public TrohomepageCategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<TrohomepageCategory> list) {
        this.mlistTrohomepageCategory = list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_itemcategory,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        TrohomepageCategory trohomepageCategory=mlistTrohomepageCategory.get(position);
        if(trohomepageCategory==null){
            return;
        }
        holder.txtNameTrocategory.setText(trohomepageCategory.getNametroCategory());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL,false);
        holder.rcvTrocategory.setLayoutManager(linearLayoutManager);
        TrohomepageAdapter trohomepageAdapter=new TrohomepageAdapter();
        trohomepageAdapter.setData(trohomepageCategory.getTrohomepage());
        holder.rcvTrocategory.setAdapter(trohomepageAdapter);

    }

    @Override
    public int getItemCount() {
        if(mlistTrohomepageCategory!=null){
            return mlistTrohomepageCategory.size();
        }
        return 0;

    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNameTrocategory;
        private RecyclerView rcvTrocategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameTrocategory=itemView.findViewById(R.id.txt_name_trocategory);
            rcvTrocategory=itemView.findViewById(R.id.rcv_trocategory);


        }
    }
}

