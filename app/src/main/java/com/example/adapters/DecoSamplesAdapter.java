package com.example.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.DecoSamples;
import com.example.moroapplication.Activity_Deco_Details;
import com.example.moroapplication.R;


import java.util.List;

public class DecoSamplesAdapter extends RecyclerView.Adapter<DecoSamplesAdapter.DecoSamplesViewHolder> {
    private List<DecoSamples> ListDecoSamples;

    public DecoSamplesAdapter(List<DecoSamples> listDecoSamples) {
        ListDecoSamples = listDecoSamples;
    }

    @NonNull
    @Override
    public DecoSamplesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_itemdecodetail, parent, false);
        return new DecoSamplesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DecoSamplesViewHolder holder, int position) {
        DecoSamples decoSamples = ListDecoSamples.get(position);
        if (decoSamples == null) {
            return;
        }
        holder.imv_DecoSamples.setImageResource(decoSamples.getImv_DecoSample());
    }

    @Override
    public int getItemCount() {
        return ListDecoSamples.size();
    }

    public class DecoSamplesViewHolder extends RecyclerView.ViewHolder {
        private ImageView imv_DecoSamples;

        public DecoSamplesViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_DecoSamples = itemView.findViewById(R.id.imv_DecoSamples);
        }
    }
}
