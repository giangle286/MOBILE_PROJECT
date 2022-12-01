package com.example.moroapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moroapplication.databinding.ActivityChooseServiceRoommateBinding;

public class Activity_Choose_Service_Roommate extends AppCompatActivity {

    ActivityChooseServiceRoommateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_choose_service_roommate);
        binding = ActivityChooseServiceRoommateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    // nhớ sửa lại class
    private void addEvents() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Choose_Service_Roommate.this,Activity_Register.class);
                startActivity(intent);
            }
        });
    }
}