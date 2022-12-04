package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.adapters.BlogAdapter;
import com.example.adapters.Trosautimkiem;
import com.example.adapters.TrosautimkiemAdapter;
import com.example.models.Blog;
import com.example.models.Trangsautimkiem;
import com.example.moroapplication.databinding.ActivityTranghienthisautimkiemBinding;

import java.util.ArrayList;

public class activity_tranghienthisautimkiem extends AppCompatActivity {
      ActivityTranghienthisautimkiemBinding binding;
      ArrayList<Trosautimkiem> TrosautimkiemList;
      TrosautimkiemAdapter gvadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tranghienthisautimkiem);
        binding = ActivityTranghienthisautimkiemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        TrosautimkiemList = new ArrayList<>();
        TrosautimkiemList.add(new Trosautimkiem("Nhà trọ Thủ Đức", "2 triệu/tháng", "20m2","17/4 Thủ Đức", R.drawable.img_nt5));
        TrosautimkiemList.add(new Trosautimkiem("Nhà trọ Thủ Đức", "2 triệu/tháng", "20m2","17/4 Thủ Đức", R.drawable.img_nt1));
        TrosautimkiemList.add(new Trosautimkiem("Nhà trọ Thủ Đức", "2 triệu/tháng", "20m2","17/4 Thủ Đức", R.drawable.img_nt1));
        TrosautimkiemList.add(new Trosautimkiem("Nhà trọ Thủ Đức", "2 triệu/tháng", "20m2","17/4 Thủ Đức", R.drawable.img_nt1));

        gvadapter = new TrosautimkiemAdapter(activity_tranghienthisautimkiem.this, R.layout.activity_nhatrosample, TrosautimkiemList);
        binding.gvSautimkiem.setAdapter(gvadapter);



    }
}