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

public class Activity_Deco_Post extends AppCompatActivity {

    String[] items = {"Vintage", "Tối giản", "Hiện đại"};
    AutoCompleteTextView autoTxtType;
    ArrayAdapter<String> adapterItems;
    BottomSheetDialog sheetDialog;

    ImageView imvDecoImage;
    Button btnDecoImage, btnDecoTest, btnCamera, btnGallery;
    ImageButton btn_Decoback;
    EditText edtDecoUser, edtDecoName, edtDecoDescribe;

    ActivityResultLauncher<Intent> activityResultLauncher;
    boolean IsCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deco_post);

        imvDecoImage = findViewById(R.id.imvDecoImage);
        edtDecoUser = findViewById(R.id.edtDecoUser);
        edtDecoName = findViewById(R.id.edtDecoName);
        edtDecoDescribe = findViewById(R.id.edtDecoDescribe);

        btnDecoImage = findViewById(R.id.btnDecoImage);
        btnDecoTest = findViewById(R.id.btnDecoTest);
        btn_Decoback = findViewById(R.id.btn_Decoback);

        autoTxtType = findViewById(R.id.txtDecoType);
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
                        imvDecoImage.setImageBitmap(bitmap);
                    } else {
                        Uri uri = result.getData().getData();
                        if (uri != null) {
                            try {
                                InputStream inputStream = getContentResolver().openInputStream(uri);
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                imvDecoImage.setImageBitmap(bitmap);
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

    private void addEvents() {
        // button back
        btn_Decoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Deco_Post.this, HomePage.class);
                startActivity(intent);
            }
        });

        // button image
        btnDecoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetDialog.show();
            }
        });

        // button test
        btnDecoTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = autoTxtType.getText().toString();
                String user = edtDecoUser.getText().toString();
                String name = edtDecoName.getText().toString();
                String describe = edtDecoDescribe.getText().toString();



                // kiểm tra dữ liệu đầy đủ chưa
                if (!type.equals("") && !user.equals("") && !name.equals("") && !describe.equals("") && convertPhoto(imvDecoImage) != null) {

                    // đóng gói và truyền dữ liệu qua Activity_Latest_Post by bundle
                    Intent intent = new Intent(Activity_Deco_Post.this, Activity_Latest_DecorPost.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("type", type);
                    bundle.putString("user", user);
                    bundle.putString("name", name);
                    bundle.putString("describe", describe);
                    bundle.putByteArray("image", convertPhoto(imvDecoImage));
                    intent.putExtras(bundle);
                    startActivity(intent);

                } else {
                    Toast.makeText(Activity_Deco_Post.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
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
}