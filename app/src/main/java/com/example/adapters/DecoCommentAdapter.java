package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.models.DecoComment;
import com.example.moroapplication.R;

import java.util.List;

public class DecoCommentAdapter extends BaseAdapter {
    private Context context;
    private int item_layout;
    private List<DecoComment> mListDecoComment;

    public DecoCommentAdapter(Context context, int item_layout, List<DecoComment> mListDecoComment) {
        this.context = context;
        this.item_layout = item_layout;
        this.mListDecoComment = mListDecoComment;
    }

    @Override
    public int getCount() {
        return mListDecoComment.size();
    }

    @Override
    public Object getItem(int i) {
        return mListDecoComment.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            holder= new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(item_layout,null);
            holder.txt_ContentCmt=view.findViewById(R.id.txt_ContentCmt);
            holder.txt_NameCmt=view.findViewById(R.id.txt_NameCmt);
            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }

        DecoComment c=mListDecoComment.get(i);
        holder.txt_ContentCmt.setText(c.getCmt());
        holder.txt_NameCmt.setText(c.getName());
        return view;
    }

    public static class ViewHolder{

        TextView txt_ContentCmt,txt_NameCmt;


    }
}
