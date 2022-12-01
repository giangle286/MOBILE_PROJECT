package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Activity_Loading extends AppCompatActivity {

    private static int LOADING = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading);

        new Handler().postDelayed((Runnable) () -> {
            Intent intent;
            intent = new Intent(Activity_Loading.this, Activity_Login.class);
            startActivity(intent);
            finish();
        },LOADING);
    }
}