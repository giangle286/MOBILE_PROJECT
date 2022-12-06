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
import com.example.models.Search;
import com.example.moroapplication.Activity_search_details;
import com.example.moroapplication.R;
import com.example.moroapplication.activity_rental_details;

import java.io.Serializable;
import java.util.List;

public class AfterSearchAdapter  extends RecyclerView.Adapter<AfterSearchAdapter.SearchViewHolder>{
    private Context mContext;
    private List<Search> mListSearch;

    public AfterSearchAdapter(Context mContext, List<Search> mListSearch) {
        this.mContext = mContext;

    }

    public void setData(List<Search>list){
        this.mListSearch=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_itemsearch,parent,false);
        return new AfterSearchAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AfterSearchAdapter.SearchViewHolder holder, int position) {
        Search search=mListSearch.get(position);
        if(search==null){
            return;
        }
        holder.imgtro.setImageResource(search.getImgtro());

        holder.txtgiatro.setText(search.getTxtgiatro());
        holder.txtdientichtro.setText(search.getTxtdientichtro());
        holder.txtdiachitro.setText(search.getTxtdiachitro());
        holder.layout_itemsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search Search;
                onClickGoToSearchDetails(search);
            }

            private void onClickGoToSearchDetails(Search search) {
                Intent intent=new Intent(mContext, Activity_search_details.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("object_search", search);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        if(mListSearch!=null){
            return mListSearch.size();
        }
        return 0;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout layout_itemsearch;
        ImageView imgtro;
        private TextView txtgiatro;
        private TextView txtdientichtro;
        private TextView txtdiachitro;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_itemsearch=itemView.findViewById(R.id.layout_itemsearch);
            imgtro=itemView.findViewById(R.id.img_tro);
            txtgiatro=itemView.findViewById(R.id.txt_giatro);
            txtdientichtro=itemView.findViewById(R.id.txt_dientichtro);
            txtdiachitro=itemView.findViewById(R.id.txt_diachitro);

        }
    }

}
