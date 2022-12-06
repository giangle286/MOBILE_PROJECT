package com.example.moroapplication;

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

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.database.PostDB;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity_Post_Rent extends AppCompatActivity {

    String[] items = {"Phòng trọ", "Căn hộ", "Nhà nguyên căn"};
    AutoCompleteTextView autoTxtType;
    ArrayAdapter<String> adapterItems;
    ImageView imvImage;
    Button btnImage, btnPost, btnCamera, btnGallery;
    ImageButton btnBack;
    EditText edtName, edtSdt, edtAddress, edtSquare, edtNumofPeople, edtPrice, edtDescribe;
    ActivityResultLauncher<Intent> activityResultLauncher;
    BottomSheetDialog sheetDialog;
    boolean IsCamera;

    public static PostDB db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_rent);

        edtName = findViewById(R.id.edtName);
        edtAddress  =findViewById(R.id.edtAddress);
        edtSdt = findViewById(R.id.edtSdt);
        edtPrice = findViewById(R.id.edtPrice);
        edtDescribe = findViewById(R.id.edtDescribe);
        edtSquare  = findViewById(R.id.edtSquare);
        edtNumofPeople = findViewById(R.id.edtNumofPeople);

        btnPost = findViewById(R.id.btnPost);
        btnBack = findViewById(R.id.btn_back);
        imvImage = findViewById(R.id.imvImage);
        btnImage = findViewById(R.id.btnImage);

        autoTxtType = findViewById(R.id.txtType);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item_post_rent, items);
        autoTxtType.setAdapter(adapterItems);

        autoTxtType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                //Result get.Data()
                if(result.getResultCode()==RESULT_OK && result.getData() !=null){
                    if(IsCamera){
                        Bitmap bitmap =(Bitmap) result.getData().getExtras().get("data");
                        imvImage.setImageBitmap(bitmap);
                    }else {
                        Uri uri =result.getData().getData();
                        if(uri !=null){
                            try {
                                InputStream inputStream=getContentResolver().openInputStream(uri);
                                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                                imvImage.setImageBitmap(bitmap);
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
                    Intent intent = new Intent(Activity_Post_Rent.this,Activity_Homepage.class);
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
                String Loaibai, Ten, SDT, Dientich, Diachi, Mucgia, Mota;
                Float SoNguoi;

                Loaibai = autoTxtType.getText().toString();
                Ten = edtName.getText().toString();
                SDT = edtSdt.getText().toString();
                Dientich = edtSquare.getText().toString();
                SoNguoi = Float.valueOf(edtNumofPeople.getText().toString());
                Diachi = edtAddress.getText().toString();
                Mucgia  =edtPrice.getText().toString();
                Mota  =edtDescribe.getText().toString();

                if(!Loaibai.equals("") && !Ten.equals("") && !SDT.equals("") && !Dientich.equals("") && !SoNguoi.equals("") && !Diachi.equals("") && !Mucgia.equals("") && !Mota.equals("") ) {
                    boolean flag = db.insertData(Loaibai, Ten, SDT, Mucgia, Diachi, Dientich, Double.valueOf(SoNguoi), Mota, convertImage());
                }
            }
        });
    }
            private byte[] convertImage() {
                BitmapDrawable drawable = (BitmapDrawable) imvImage.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                return outputStream.toByteArray();
            }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
