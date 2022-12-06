package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.adapters.AfterSearchAdapter;
import com.example.models.Search;

import java.util.ArrayList;
import java.util.List;

public class activity_aftersearch extends AppCompatActivity {

    private RecyclerView rcvSearch;
    private AfterSearchAdapter mAfterSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftersearch);

        rcvSearch = findViewById(R.id.rcv_search);
        mAfterSearchAdapter = new AfterSearchAdapter(this, getListSearch());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        ;
        rcvSearch.setLayoutManager(gridLayoutManager);
        mAfterSearchAdapter.setData(getListSearch());
        rcvSearch.setAdapter(mAfterSearchAdapter);
    }

    private List<Search> getListSearch() {
        List<Search>list=new ArrayList<>();
        list.add(new Search(R.drawable.img_nt1, "Nhà trọ Thủ Đức","1 triệu", "10m2","16/5"));
        list.add(new Search(R.drawable.img_nt2, "Nhà trọ Thủ Đức","700 ngàn", "20m2","17/4, Linh Trung, Thủ Đức"));
        list.add(new Search(R.drawable.img_nt3, "Nhà trọ Thủ Đức","700 ngàn", "30m2","17/4, Linh Trung, Thủ Đức"));
        list.add(new Search(R.drawable.img_nt4, "Nhà trọ Thủ Đức","700 ngàn", "40m2","17/4, Linh Trung, "));
    return list;
    }
}
