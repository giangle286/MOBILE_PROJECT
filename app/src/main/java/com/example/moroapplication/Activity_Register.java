package com.example.moroapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AccountDB;
import com.google.android.material.textfield.TextInputEditText;

public class Activity_Register extends AppCompatActivity {

    Button btnRegister;
    TextInputEditText edtName,edtEmail,edtPass,edtPassAgain;

    AccountDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister=findViewById(R.id.btnRegister);
        edtName=findViewById(R.id.edtName);
        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPass);
        edtPassAgain=findViewById(R.id.edtPassAgain);
        DB=new AccountDB(this);


                    btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name=edtName.getText().toString();
                    String email=edtEmail.getText().toString();
                    String pass=edtPass.getText().toString();
                    String repass=edtPassAgain.getText().toString();
                    if(name.equals("")||email.equals("")||pass.equals("")||repass.equals("")){
                        Toast.makeText(Activity_Register.this, "Bạn cần điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }else{
                        if(pass.equals(repass)){
                            boolean checkemail = DB.checkemail(email);
                            if(checkemail==false){
                                boolean insertData = DB.insertData(name,email,pass);
                                if(insertData==true){
                                    Intent in = new Intent(Activity_Register.this, Activity_Success_Register.class);
                                    in.putExtra("email",email);
                                    startActivity(in);
                                }else{
                                    Toast.makeText(Activity_Register.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(Activity_Register.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Activity_Register.this, "Nhập lại mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                        }

                    }


                }
                    });
    }
}