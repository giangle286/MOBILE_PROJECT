package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.ShareroomCategory;
import com.example.moroapplication.R;

import java.util.List;

public class ShareroomCategoryAdapter extends RecyclerView.Adapter<ShareroomCategoryAdapter.CategoryViewHolder>  {
    private Context mContext;
    private List<ShareroomCategory> mlistShareroomCategory;

    public ShareroomCategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<ShareroomCategory>list){
        this.mlistShareroomCategory=list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_shareroom_itemcategory,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        ShareroomCategory shareroomCategory=mlistShareroomCategory.get(position);
        if(shareroomCategory==null){
            return;
        }
        holder.txtnameshareroomcategory.setText(shareroomCategory.getNameshareroomCategory());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL,false);
        holder.rcvshareroom.setLayoutManager(linearLayoutManager);
        ShareroomAdapter decoAdapter=new ShareroomAdapter();
        decoAdapter.setData(shareroomCategory.getShareroom());
        holder.rcvshareroom.setAdapter(decoAdapter);

    }

    @Override
    public int getItemCount() {
        if(mlistShareroomCategory!=null){
            return mlistShareroomCategory.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView  txtnameshareroomcategory;
        private RecyclerView rcvshareroom;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnameshareroomcategory=itemView.findViewById(R.id.txt_nameshareroom_category);
            rcvshareroom=itemView.findViewById(R.id.rcv_shareroom);

        }
    }
}
//shareroom
