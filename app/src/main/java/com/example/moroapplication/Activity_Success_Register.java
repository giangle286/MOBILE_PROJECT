package com.example.moroapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Success_Register extends AppCompatActivity {

    Button btnback;
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
        btnback = findViewById(R.id.btn_back);
        btnGetStart=findViewById(R.id.btnGetStart);
    }

    private void addEvents() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Success_Register.this,Activity_Register.class);
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