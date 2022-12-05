package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapters.DecorAdapter;
import com.example.models.Deco;
import com.example.models.Decor;

import java.util.ArrayList;
import java.util.List;

public class Activity_Decor extends AppCompatActivity {
    private RecyclerView rcvDecor;
    private DecorAdapter mDecorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decor);

        rcvDecor=findViewById(R.id.rcv_decor);
        mDecorAdapter=new DecorAdapter(this,getListDecor());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcvDecor.setLayoutManager(gridLayoutManager);
        mDecorAdapter.setData(getListDecor());
        rcvDecor.setAdapter(mDecorAdapter);

    }
    private List<Decor> getListDecor(){
        List<Decor>list=new ArrayList<>();
        list.add(new Decor(R.drawable.sample1,"Decor tối giản","Nhật Linh","2 phút trước"));
        list.add(new Decor(R.drawable.sample2,"Phòng công chúa","Thùy Dung","10 phút trước"));
        list.add(new Decor(R.drawable.sample3,"Mẫu deco đẹp","Linh Anh","20 phút trước"));
        list.add(new Decor(R.drawable.sample1,"Decor tối giản","Nhật Linh","2 phút trước"));
        list.add(new Decor(R.drawable.sample2,"Phòng công chúa","Thùy Dung","10 phút trước"));
        list.add(new Decor(R.drawable.sample3,"Mẫu deco đẹp","Linh Anh","20 phút trước"));

        return list;

    }
}