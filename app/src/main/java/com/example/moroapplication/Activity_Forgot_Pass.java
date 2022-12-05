package com.example.moroapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AccountDB;
import com.example.moroapplication.databinding.ActivityForgotPassBinding;

public class Activity_Forgot_Pass extends AppCompatActivity {

    ActivityForgotPassBinding binding;
    AccountDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_forgot_pass);
        binding = ActivityForgotPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DB=new AccountDB(this);

        // Back
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Forgot_Pass.this,Activity_Login.class);
                startActivity(intent);
            }
        });

        // Đặt lại mật khẩu

        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String verifiedEmail = binding.edtEmailVerify.getText().toString();

                        if (verifiedEmail.equals("")){
                            Toast.makeText(Activity_Forgot_Pass.this, "Vui lòng nhập email!", Toast.LENGTH_SHORT).show();
                        }else {
                            if(DB.checkemail(verifiedEmail)){
                                Toast.makeText(Activity_Forgot_Pass.this, "Xác thực tài khoản thành công, bạn có thể đặt lại mật khẩu sau 5s nữa!", Toast.LENGTH_SHORT).show();

                                // Tạo thời gian chờ 5s
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                // Điều hướng đến màn hình đặt lại mật khẩu
                                Intent intent = new Intent(Activity_Forgot_Pass.this,Activity_Reset_Password.class);
                                startActivity(intent);

                            }else {
                                Toast.makeText(Activity_Forgot_Pass.this,"Tài khoản không tồn tại, vui lòng kiểm tra lại!", Toast.LENGTH_LONG).show();
                            }

                        }
                    }
                });

    }
}