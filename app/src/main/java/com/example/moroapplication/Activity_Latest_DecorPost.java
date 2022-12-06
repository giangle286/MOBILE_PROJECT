package com.example.moroapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.database.PostdecorDB;
import com.example.moroapplication.databinding.ActivityLatestDecorPostBinding;

public class Activity_Latest_DecorPost extends AppCompatActivity {
    public static PostdecorDB db;
    ActivityLatestDecorPostBinding binding;
    Dialog dialogWait;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_latest_decor_post);
        binding = ActivityLatestDecorPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new PostdecorDB(this);

        // back button
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Latest_DecorPost.this,Activity_Deco_Post.class);
                startActivity(intent);
            }
        });

        // Nhận dữ liệu từ Activity_Deco_Post với bundle
        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("type");
        String user = bundle.getString("user");
        String name = bundle.getString("name");
        String describe = bundle.getString("describe");
        byte[] image = (byte[]) bundle.get("image");

        // Chuyển đổi Byte[] sang Bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);

        // Hiện thị dữ liệu lên giao diện
        binding.txtName.setText(name);
        binding.txtUser.setText(user);
        binding.txtDescribe.setText(describe);
        binding.imgDecoDetails.setImageBitmap(bitmap);

        binding.btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo dialog xác nhận
                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Latest_DecorPost.this);
                builder.setTitle("Đăng bài");
                builder.setMessage("Bạn có chắc chắn muốn đăng bài không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Lưu dữ liệu vào database
                        db.insertData(image,name, user, type);
                        boolean check = db.insertData(image, name, user, type);
                        if (check == true) {
                            Toast.makeText(Activity_Latest_DecorPost.this, "Vui lòng chờ admin duyệt bài!", Toast.LENGTH_SHORT).show();
                            // chờ 5s

                            dialogWait = new Dialog(Activity_Latest_DecorPost.this);
                            dialogWait.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialogWait.setContentView(R.layout.dialog_wait);
                            dialogWait.setCanceledOnTouchOutside(false);
                            dialogWait.show();

                            new CountDownTimer(5000,100){

                                @Override
                                public void onTick(long l) {
                                }

                                @Override
                                public void onFinish() {
                                    dialogWait.dismiss();
                                }
                            }.start();
                            Toast.makeText(Activity_Latest_DecorPost.this, "Bài của bạn đã được duyệt, đăng bài thành công!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Activity_Latest_DecorPost.this, HomePage.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Activity_Latest_DecorPost.this, "Đăng bài không thành công, vui lòng thử lại!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        });
        }

    }
