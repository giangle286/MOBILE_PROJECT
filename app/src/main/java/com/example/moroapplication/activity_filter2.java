package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moroapplication.databinding.ActivityFilter2Binding;

import java.util.ArrayList;

public class activity_filter2 extends AppCompatActivity {

    TextView txtPrice, txtType, txtAddress;
    Spinner spnPrice, spnType, spnAddress;
    Button btnFilter;
    ActivityFilter2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter2);
        binding = ActivityFilter2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();

        spnAddress = findViewById(R.id.spr_address);
        spnType = findViewById(R.id.spr_typeRoom);
        spnPrice = findViewById(R.id.spr_price);

        txtAddress = findViewById(R.id.txt_addressRoom);
        txtType = findViewById(R.id.txt_type);
        txtPrice = findViewById(R.id.txt_priceRoom);

        btnFilter = findViewById(R.id.btn_filterSubmit);

        ArrayList<String> aList = new ArrayList<>();
        ArrayList<String> tList = new ArrayList<>();
        ArrayList<String> pList = new ArrayList<>();

        aList.add("Hà Nội");
        aList.add("TP. Hồ Chí Minh");
        aList.add("Đà Nẵng");
        aList.add("Hải Phòng");
        aList.add("Cần Thơ");
        aList.add("An Giang");
        aList.add("Bà Rịa - Vũng Tàu");
        aList.add("Bắc Giang");
        aList.add("Bắc Kạn");
        aList.add("Bạc Liêu");
        aList.add("Bắc Ninh");
        aList.add("Bến Tre");
        aList.add("Bình Định");
        aList.add("Bình Dương");
        aList.add("Bình Phước");
        aList.add("Bình Thuận");
        aList.add("Cà Mau");
        aList.add("Cao Bằng");
        aList.add("Đắk Lắk");
        aList.add("Đắk Nông");
        aList.add("Điện Biên");
        aList.add("Đồng Nai");
        aList.add("Đồng Tháp");
        aList.add("Gia Lai");
        aList.add("Hà Giang");
        aList.add("Hà Nam");
        aList.add("Hà Tĩnh");
        aList.add("Hải Dương");
        aList.add("Hậu Giang");
        aList.add("Hòa Bình");
        aList.add("Hưng Yên");
        aList.add("Khánh Hòa");
        aList.add("Kiên Giang");
        aList.add("Kon Tum");
        aList.add("Lai Châu");
        aList.add("Lâm Đồng");
        aList.add("Lạng Sơn");
        aList.add("Lào Cai");
        aList.add("Long An");
        aList.add("Nam Định");
        aList.add("Nghệ An");
        aList.add("Ninh Bình");
        aList.add("Ninh Thuận");
        aList.add("Phú Thọ");
        aList.add("Quảng Bình");
        aList.add("Quảng Nam");
        aList.add("Quảng Ngãi");
        aList.add("Quảng Ninh");
        aList.add("Quảng Trị");
        aList.add("Sóc Trăng");
        aList.add("Sơn La");
        aList.add("Tây Ninh");
        aList.add("Thái Bình");
        aList.add("Thái Nguyên");
        aList.add("Thanh Hóa");
        aList.add("Thừa Thiên Huế");
        aList.add("Tiền Giang");
        aList.add("Trà Vinh");
        aList.add("Tuyên Quang");
        aList.add("Vĩnh Long");
        aList.add("Vĩnh Phúc");
        aList.add("Yên Bái");
        aList.add("Phú Yên");



        tList.add("Phòng trọ");
        tList.add("Nhà nguyên căn");
        tList.add("Homestay");
        tList.add("Chung cư mini");
        tList.add("Chung cư nguyên căn");
        tList.add("Chung cư dịch vụ");
        tList.add("Chung cư cao cấp");
        tList.add("Chung cư tập thể");
        tList.add("Chung cư khách sạn");
        tList.add("Nhà nghỉ");

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
        pList.add("Trên 14 triệu");

        spnAddress.setAdapter(new ArrayAdapter<>(activity_filter2.this, android.R.layout.simple_spinner_dropdown_item, aList));
        spnAddress.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                txtAddress.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(activity_filter2.this, "Vui lòng chọn", Toast.LENGTH_SHORT).show();
            }
        });

        spnType.setAdapter(new ArrayAdapter<>(activity_filter2.this, android.R.layout.simple_spinner_dropdown_item, tList));
        spnType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                txtType.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(activity_filter2.this, "Vui lòng chọn", Toast.LENGTH_SHORT).show();
            }
        });

        spnPrice.setAdapter(new ArrayAdapter<>(activity_filter2.this, android.R.layout.simple_spinner_dropdown_item, pList));
       spnPrice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                txtPrice.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(activity_filter2.this, "Vui lòng chọn", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addEvents() {
        binding.btnFilterSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_filter2.this, Activity_Homepage.class);
                startActivity(intent);
            }
        });
    }




}