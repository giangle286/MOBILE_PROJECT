package com.example.moroapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AccountDB;
import com.example.moroapplication.databinding.ActivityRegisterBinding;
import com.google.android.material.textfield.TextInputEditText;

public class Activity_Register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    Button btnRegister, btnAlreadyHaveAccount;
    TextInputEditText edtName,edtEmail,edtPass,edtPassAgain, edtAddress, edtPhone;

    AccountDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_register);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnRegister = binding.btnRegister;
        btnAlreadyHaveAccount = binding.btnAlreadyHaveAccount;
        edtName = binding.edtName;
        edtEmail = binding.edtEmail;
        edtPass = binding.edtPass;
        edtPassAgain = binding.edtPassAgain;
        edtAddress = binding.edtAddress;
        edtPhone = binding.edtPhone;

        DB=new AccountDB(this);

        // Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name=edtName.getText().toString();
                    String email=edtEmail.getText().toString();
                    String pass=edtPass.getText().toString();
                    String repass=edtPassAgain.getText().toString();
                    String address=edtAddress.getText().toString();
                    String phone=edtPhone.getText().toString();

                    //check if the fields are empty
                if(name.equals("")||email.equals("")||pass.equals("")||repass.equals("")||address.equals("")||phone.equals(""))
                        Toast.makeText(Activity_Register.this, "Bạn cần điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    else{
                        //check if the email already exists
                        if(DB.checkemail(email)){
                            Toast.makeText(Activity_Register.this, "Tài khoản đã tồn tại, vui lòng đăng nhập", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //check if the passwords match
                            if(pass.equals(repass)){

                                // lưu vào database Account
                                Boolean insert = DB.insertAccData(name, email, pass, address, phone);
                                if(insert==true){
                                    Toast.makeText(Activity_Register.this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();

                                    // Chuyển qua màn hình trang chủ
                                    Intent intent = new Intent(Activity_Register.this,HomePage.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(Activity_Register.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(Activity_Register.this, "Nhập lại mật khẩu không khớp, vui lòng kiểm tra lại!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


                }
            });

            //Chuyển qua màn hình đăng nhập
            btnAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Register.this,Activity_Login.class);
                    startActivity(intent);
                }
            });

    }
}