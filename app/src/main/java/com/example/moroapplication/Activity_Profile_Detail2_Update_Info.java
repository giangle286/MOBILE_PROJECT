package com.example.moroapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.database.PostDB;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity_Profile_Detail2_Update_Info extends AppCompatActivity {

    //AutoCompleteTextView autoTxtType;
    ImageView imvAva;
    Button btnImage, btnPost, btnCamera, btnGallery, btnSave;
    ImageButton btnBack;
    EditText edtName, edtPhone, edtEmail, edtAddress;
    ActivityResultLauncher<Intent> activityResultLauncher;
    BottomSheetDialog sheetDialog;
    boolean IsCamera;


    @SuppressLint("MissingInflatedId")
    public static PostDB db;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile_detail2_update_info);

            edtName = findViewById(R.id.edt_name);
            edtAddress  =findViewById(R.id.edt_address);
            edtPhone = findViewById(R.id.edt_phone);
            edtEmail = findViewById(R.id.edt_email);
            imvAva = findViewById(R.id.imv_ava);
            btnSave= findViewById(R.id.btn_save);


//            autoTxtType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    String item = parent.getItemAtPosition(position).toString();
//                }
//            });

            activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //Result get.Data()
                    if(result.getResultCode()==RESULT_OK && result.getData() !=null){
                        if(IsCamera){
                            Bitmap bitmap =(Bitmap) result.getData().getExtras().get("data");
                            imvAva.setImageBitmap(bitmap);
                        }else {
                            Uri uri =result.getData().getData();
                            if(uri !=null){
                                try {
                                    InputStream inputStream=getContentResolver().openInputStream(uri);
                                    Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                                    imvAva.setImageBitmap(bitmap);
                                }catch (FileNotFoundException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                }
            });
            addEvents();
            createBottomSheet();

        }

        @SuppressLint("MissingInflatedId")
        private void createBottomSheet() {

            if(sheetDialog == null){
                View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet,null);
                btnCamera = view.findViewById(R.id.btnCamera);
                btnCamera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // open Camera
                        IsCamera  =true;
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        activityResultLauncher.launch(intent);
                        sheetDialog.dismiss();
                    }
                });

                btnGallery  =view.findViewById(R.id.btnGallery);
                btnGallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //open gallery
                        IsCamera = false;
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        activityResultLauncher.launch(intent);
                        sheetDialog.dismiss();
                    }
                });

                sheetDialog = new BottomSheetDialog(this);
                sheetDialog.setContentView(view);

            }
        }

        private void addEvents() {
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Profile_Detail2_Update_Info.this,Activity_Profile_Detail2.class);
                    startActivity(intent);
                }
            });
            btnImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sheetDialog.show();
                }
            });
            btnPost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // insertData
                    String Loaibai, Ten, SDT, Email, DiaChi;

                    Ten = edtName.getText().toString();
                    SDT = edtPhone.getText().toString();
                    DiaChi = edtAddress.getText().toString();
                    Email = edtEmail.getText().toString();

                }
        private byte[] convertImage() {
            BitmapDrawable drawable = (BitmapDrawable) imvAva.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            return outputStream.toByteArray();
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

    });
        }
    }




