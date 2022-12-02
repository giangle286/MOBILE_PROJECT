package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adapters.DecoSamplesAdapter;
import com.example.models.DecoSamples;
import com.example.moroapplication.databinding.ActivityDecoDetailsBinding;

import java.util.ArrayList;

public class Activity_Deco_Details extends AppCompatActivity {
    ActivityDecoDetailsBinding binding;
    DecoSamplesAdapter adapter;
    ArrayList<DecoSamples>DecoSamplesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_deco_details);
        binding=ActivityDecoDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();

    }

    private void loadData() {
        DecoSamplesList=new ArrayList<>();
        DecoSamplesList.add(new DecoSamples(R.drawable.deco_detail1));
        DecoSamplesList.add(new DecoSamples(R.drawable.deco_detail2));
        DecoSamplesList.add(new DecoSamples(R.drawable.deco_detail3));
//        adapter=new DecoSamplesAdapter(Activity_Deco_Details.this,R.layout.activity_itemdecodetail);
////        binding.imvDecoSamples.setAda

    }
}