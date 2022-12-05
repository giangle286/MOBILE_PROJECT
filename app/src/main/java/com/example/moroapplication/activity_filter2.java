package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class activity_filter2 extends AppCompatActivity {

    TextView txtPrice, txtType, txtAddress;
    Spinner spnPrice, spnType, spnAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter2);

        spnAddress = findViewById(R.id.spr_address);
        spnType = findViewById(R.id.spr_typeRoom);
        spnPrice = findViewById(R.id.spr_price);

        txtAddress = findViewById(R.id.txt_addressRoom);
        txtType = findViewById(R.id.txt_type);
        txtPrice = findViewById(R.id.txt_priceRoom);

        ArrayList<String> aList = new ArrayList<>();
        ArrayList<String> tList = new ArrayList<>();
        ArrayList<String> pList = new ArrayList<>();

        aList.add("Hà Nội");
        aList.add("Hồ Chí Minh");
        aList.add("Đà Nẵng");
        aList.add("Hải Phòng");
        aList.add("Cần Thơ");
        aList.add("An Giang");
        aList.add("Bà Rịa - Vũng Tàu");
        aList.add("Bình Dương");
        aList.add("Long An");
        aList.add("Đồng Nai");
        aList.add("Đắk Lắk");
        aList.add("Đắk Nông");
        aList.add("Bình Phước");
        aList.add("Bình Thuận");
        aList.add("Đà Lạt");
        aList.add("Bảo Lộc");

        tList.add("Phòng trọ");
        tList.add("Nhà nguyên căn");
        tList.add("Chung cư mini");
        tList.add("Chung cư nguyên căn");
        tList.add("Chung cư dịch vụ");
        tList.add("Chung cư cao cấp");

        pList.add("Dưới 1 triệu");
        pList.add("1 - 2 triệu");
        pList.add("2 - 3 triệu");
        pList.add("3 - 4 triệu");
        pList.add("4 - 5 triệu");
        pList.add("5 - 6 triệu");
        pList.add("6 - 8 triệu");
        pList.add("8 - 10 triệu");
        pList.add("10 - 12 triệu");
        pList.add("12 - 14 triệu");
        pList.add("trên 14 triệu");

        spnAddress.setAdapter(new ArrayAdapter<>(activity_filter2.this, android.R.layout.simple_spinner_dropdown_item, aList));
        spnAddress.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              txtAddress.setText(parent.getItemAtPosition(position).toString());
                Toast.makeText(activity_filter2.this, "Vui lòng chọn", Toast.LENGTH_SHORT).show();
            }
        });

        spnType.setAdapter(new ArrayAdapter<>(activity_filter2.this, android.R.layout.simple_spinner_dropdown_item, tList));
        spnType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtType.setText(parent.getItemAtPosition(position).toString());
                Toast.makeText(activity_filter2.this, "Vui lòng chọn", Toast.LENGTH_SHORT).show();
            }
        });

        spnPrice.setAdapter(new ArrayAdapter<>(activity_filter2.this, android.R.layout.simple_spinner_dropdown_item, pList));
        spnAddress.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtPrice.setText(parent.getItemAtPosition(position).toString());
                Toast.makeText(activity_filter2.this, "Vui lòng chọn", Toast.LENGTH_SHORT).show();
            }
        });

    }
}