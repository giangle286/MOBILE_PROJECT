package com.example.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.Blog;
import com.example.moroapplication.R;

import java.util.List;

public class BlogAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Blog> blogList;


    public BlogAdapter(Context context, int layout, List<Blog> blogList) {
        this.context = context;
        this.layout = layout;
        this.blogList = blogList;
    }


    @Override
    public int getCount() {
        return blogList.size();
    }

    @Override
    public Object getItem(int i) {
        return blogList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null){
            holder=new ViewHolder();
            view =inflater.inflate(layout,null);
            holder.imvBlog=view.findViewById(R.id.imvImage);
            holder.txtTitleBlog=view.findViewById(R.id.txt_titleBlog);
            holder.imvReact=view.findViewById(R.id.imv_ic_tim);
            holder.imvCmt=view.findViewById(R.id.imv_ic_cmt);
            view.setTag(holder);
        }
        else {
            holder= (ViewHolder) view.getTag();

        }

        Blog b = blogList.get(i);
        holder.txtTitleBlog.setText(b.getTitleBlog());
        holder.imvBlog.setImageResource(b.getImageBlog());

//        products b = beers.get(i);
//
//        holder.imvbeer.setImageResource(b.getImvbeer());
//        holder.txtname.setText(b.getName());
//        return view;

        holder.imvReact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imvReact=view.findViewById(R.id.imv_ic_tim);
                imvReact.setSelected(!imvReact.isSelected());
                if(imvReact.isSelected()){
                    imvReact.setImageResource(R.drawable.ic_baseline_favoritefull_24);
                }else {
                    imvReact.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                }
            }
        });

//        holder.imvCmt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent= new Intent(view.getContext(),CommentBlog.class);
//                view.getContext().startActivity(intent);
//
//            }
//        });
        return view;
    }
    public static class ViewHolder {
        TextView txtTitleBlog;
        ImageView imvBlog;
        ImageView imvReact, imvCmt;

    }

}

