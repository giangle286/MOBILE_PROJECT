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
                        Toast.makeText(Activity_Register.this, "B???n c???n ??i???n ?????y ????? th??ng tin", Toast.LENGTH_SHORT).show();
                    else{
                        //check if the email already exists
                        if(DB.checkemail(email)){
                            Toast.makeText(Activity_Register.this, "T??i kho???n ???? t???n t???i, vui l??ng ????ng nh???p", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //check if the passwords match
                            if(pass.equals(repass)){

                                // l??u v??o database Account
                                //ACCDATA ==> INSERT
                                Boolean insert = DB.insertAccData(name, email, pass, address, phone);
                                if(insert==true){
                                    Toast.makeText(Activity_Register.this, "????ng k?? t??i kho???n th??nh c??ng", Toast.LENGTH_SHORT).show();

                                    // Chuy???n qua m??n h??nh trang ch???
                                    Intent intent = new Intent(Activity_Register.this,Activity_Homepage.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(Activity_Register.this, "????ng k?? kh??ng th??nh c??ng", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(Activity_Register.this, "Nh???p l???i m???t kh???u kh??ng kh???p, vui l??ng ki???m tra l???i!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


                }
            });

            //Chuy???n qua m??n h??nh ????ng nh???p
            btnAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Register.this,Activity_Login.class);
                    startActivity(intent);
                }
            });

    }
}