package com.example.moroapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.ListView;

import com.example.models.Nhatro;

import java.util.ArrayList;

public class Activity_Homepage1 extends AppCompatActivity {
    FragmentManager manager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage1);
        //Nhúng product fragment vào
        manager = getSupportFragmentManager();
        FragmentTransaction transaction =
                manager.beginTransaction();
       transaction.replace(R.id.layoutContainer, new Nhatrofragment1());
        transaction.commit();

 //public void dataFlow(Nhatro n) {

//              FragmentTransaction transaction = manager.beginTransaction();
//            Fragment fragment = new ;
        //    transaction.replace(R.id.layoutContainer, fragment);
  //          transaction.commit();
            }

 //       }

    }
