package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moroapplication.databinding.ActivityPaymentSuccessBinding;

public class Activity_Payment_Success extends AppCompatActivity {
    Button btnCreatePost, btnBackHome;
    ActivityPaymentSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_payment_success);
        binding = ActivityPaymentSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Payment_Success.this, Activity_Choose_Service_Roommate.class);
                startActivity(intent);
            }
        });
        binding.btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Payment_Success.this, Activity_Homepage.class);
                startActivity(intent);
            }
        });
    }
}