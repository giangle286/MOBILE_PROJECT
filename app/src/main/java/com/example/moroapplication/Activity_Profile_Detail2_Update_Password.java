package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.database.AccountDB;
import com.example.moroapplication.databinding.ActivityProfileDetail2UpdatePasswordBinding;

    public class Activity_Profile_Detail2_Update_Password extends AppCompatActivity {
        ActivityProfileDetail2UpdatePasswordBinding binding;
        Button btn_UpdatePass;
        AccountDB DB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
           // binding = Activity_Profile_Detail2_Update_Password.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            DB=new AccountDB(this);

            // Đặt lại mật khẩu
            btn_UpdatePass = binding.btnUpdatePass;
            btn_UpdatePass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String oldpass = binding.edtOldPass.getText().toString();
                    String newpass = binding.edtNewPass.getText().toString();
                    String cfnewpass = binding.edtCfNewPass.getText().toString();

//                        // Kiểm tra mật khẩu mới và nhập lại mật khẩu mới có trùng nhau không
//                        if(newpass.equals(cfnewpass)){
//                            // Cập nhật mật khẩu mới
//                            boolean checkupdate = DB.updatepassword(newpass);
//                            if(checkupdate==true){
//                                Toast.makeText(com.example.moroapplication.Activity_Profile_Detail2_Update_Password.this, "Đặt lại mật khẩu thành công!", Toast.LENGTH_SHORT).show();
//                            }else{ Toast.makeText(com.example.moroapplication.Activity_Profile_Detail2_Update_Password.this, "Đặt lại mật khẩu thất bại!", Toast.LENGTH_SHORT).show(); }
//
//                            // Chuyển về màn hình profile chính
//                            Intent intent = new Intent(com.example.moroapplication.Activity_Profile_Detail2_Update_Password.this, Activity_Profile.class);
//                            startActivity(intent);
//                        }else{
//                            Toast.makeText(com.example.moroapplication.Activity_Profile_Detail2_Update_Password.this, "Mật khẩu mới và nhập lại mật khẩu mới không trùng nhau!", Toast.LENGTH_SHORT).show();
//                        }
                    }
                });
        }

    }