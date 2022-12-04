package com.example.moroapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AccountDB;
import com.example.moroapplication.databinding.ActivityResetPasswordBinding;

public class Activity_Reset_Password extends AppCompatActivity {
    ActivityResetPasswordBinding binding;
    Button btnResetPass;
    AccountDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_reset_password);
        binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Đặt lại mật khẩu
        btnResetPass = binding.btnResetPass;
        btnResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.edtEmailMk.getText().toString();
                String pass = binding.edtNewMk.getText().toString();
                String repass = binding.edtRenewMk.getText().toString();

                // Kiểm tra đã nhập đủ thông tin chưa
                if(email.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(Activity_Reset_Password.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else{

                // Kiểm tra mật khẩu mới và nhập lại mật khẩu mới có trùng nhau không
                if(pass.equals(repass)){
                    // Cập nhật mật khẩu mới
                    DB.updatepassword(email, pass);
                    boolean checkupdate=DB.updatepassword(email, pass);
                    if(checkupdate==true){
                        Toast.makeText(Activity_Reset_Password.this, "Đặt lại mật khẩu thành công! Hãy đăng nhập lại!", Toast.LENGTH_SHORT).show();
                    }else{ Toast.makeText(Activity_Reset_Password.this, "Đặt lại mật khẩu thất bại!", Toast.LENGTH_SHORT).show(); }

                    // Chuyển về màn hình đăng nhập
                     Intent intent = new Intent(Activity_Reset_Password.this, Activity_Login.class);
                     startActivity(intent);
                }else{
                    Toast.makeText(Activity_Reset_Password.this, "Mật khẩu mới và nhập lại mật khẩu mới không trùng nhau!", Toast.LENGTH_SHORT).show();
                }
            }
            }
        });

    }
}