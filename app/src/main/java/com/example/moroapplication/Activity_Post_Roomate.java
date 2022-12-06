package com.example.moroapplication;

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
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity_Post_Roomate extends AppCompatActivity {
    String[] items = {"Phòng trọ", "Căn hộ", "Nhà nguyên căn"};
    AutoCompleteTextView autoTxtType;
    ArrayAdapter<String> adapterItems;
    BottomSheetDialog sheetDialog;

    ImageView imvImage;
    Button btnImage, btnTest, btnCamera, btnGallery;
    ImageButton btnBack;
    EditText edtName, edtSdt, edtAddress, edtSquare, edtNumofPeople, edtGender, edtDescribe;

    ActivityResultLauncher<Intent> activityResultLauncher;
    boolean IsCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_roomate);

        setContentView(R.layout.activity_post_rent);

        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtSdt = findViewById(R.id.edtSdt);
        edtGender = findViewById(R.id.edtGender);
        edtDescribe = findViewById(R.id.edtDescribe);
        edtSquare = findViewById(R.id.edtSquare);
        edtNumofPeople = findViewById(R.id.edtNumofPeople);

        btnTest = findViewById(R.id.btnTest);
        btnBack = findViewById(R.id.btn_back);
        btnImage = findViewById(R.id.btnImage);

        imvImage = findViewById(R.id.imvImage);

        autoTxtType = findViewById(R.id.txtType);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item_post_rent, items);
        autoTxtType.setAdapter(adapterItems);


        // Drop down list
        autoTxtType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });

        // image
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                //Result get.Data()
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    if (IsCamera) {
                        Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                        imvImage.setImageBitmap(bitmap);
                    } else {
                        Uri uri = result.getData().getData();
                        if (uri != null) {
                            try {
                                InputStream inputStream = getContentResolver().openInputStream(uri);
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                imvImage.setImageBitmap(bitmap);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });

        createBottomSheet();
        addEvents();
    }

    // choose camera or gallery
    private void createBottomSheet() {

        if (sheetDialog == null) {
            View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet, null);
            btnCamera = view.findViewById(R.id.btnCamera);
            btnCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // open Camera
                    IsCamera = true;
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();
                }
            });

            btnGallery = view.findViewById(R.id.btnGallery);
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

        // button back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Post_Roomate.this, HomePage.class);
                startActivity(intent);
            }
        });

        // button image
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetDialog.show();
            }
        });

        // button test
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = autoTxtType.getText().toString();
                String name = edtName.getText().toString();
                String sdt = edtSdt.getText().toString();
                String gender = edtGender.getText().toString();
                String address = edtAddress.getText().toString();
                String square = edtSquare.getText().toString();
                Double numofpeople = Double.valueOf(edtNumofPeople.getText().toString());
                String describe = edtDescribe.getText().toString();

                // kiểm tra dữ liệu đầy đủ chưa

                if (!type.equals("") && !name.equals("") && !sdt.equals("") && !gender.equals("") && !address.equals("") && !square.equals("") && !describe.equals("") && !numofpeople.equals(0) && convertPhoto(imvImage) != null) {

                    // đóng gói và truyền dữ liệu qua Activity_Latest_Post by bundle
                    Intent intent = new Intent(Activity_Post_Roomate.this, Activity_Lastest_Post.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("type", type);
                    bundle.putString("name", name);
                    bundle.putString("sdt", sdt);
                    bundle.putString("gender", gender);
                    bundle.putString("address", address);
                    bundle.putString("square", square);
                    bundle.putDouble("numofpeople", numofpeople);
                    bundle.putString("describe", describe);
                    bundle.putByteArray("image", convertPhoto(imvImage));
                    intent.putExtras(bundle);
                    startActivity(intent);

                } else {
                    Toast.makeText(Activity_Post_Roomate.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private byte[] convertPhoto(ImageView imv) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imv.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

}
