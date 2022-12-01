package com.example.moroapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Success_Register extends AppCompatActivity {

    ImageView imvBack;
    FrameLayout btnGetStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);
        linkViews();
        addEvents();
    }

    @SuppressLint("WrongViewCast")
    private void linkViews() {
        imvBack=findViewById(R.id.imvBack);
        btnGetStart=findViewById(R.id.btnGetStart);
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Success_Register.this, Activity_Register.class);
                startActivity(intent);
            }
        });
        btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Success_Register.this, HomePage.class));
            }
        });
    }
}