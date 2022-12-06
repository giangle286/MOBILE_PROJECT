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

import com.example.database.PostRoommateDB;
import com.example.moroapplication.databinding.ActivityLastestRoomPostBinding;

public class Activity_Lastest_RoomPost extends AppCompatActivity {

    ActivityLastestRoomPostBinding binding;
    public static PostRoommateDB db;
    Dialog dialogWait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lastest_room_post);
        binding = ActivityLastestRoomPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db =new PostRoommateDB(this);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Lastest_RoomPost.this,Activity_Post_Roomate.class);
                startActivity(intent);
            }
        });

        // Nhận dữ liệu từ Activity_Post_Rent với bundle
        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("type");
        String name = bundle.getString("name");
        String sdt = bundle.getString("sdt");
        String gender = bundle.getString("gender");
        String address = bundle.getString("address");
        String square = bundle.getString("square");
        Double numofpeople = bundle.getDouble("numofpeople");
        String describe = bundle.getString("describe");
        byte[] image = (byte[]) bundle.get("image");

        // Chuyển đổi Byte[] sang Bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);

        // Hiển thị dữ liệu lên giao diện
        binding.txtTieude.setText(type + ", cần tìm thêm" + numofpeople + " " + gender+" , diện tích " + square + " m2, tại " + address);
        binding.txtGender.setText(gender);
        binding.txtSquare.setText(square);
        binding.txtNOB.setText(numofpeople.toString());
        binding.txtPhone.setText(sdt);
        binding.txtAddress.setText(address);
        binding.txtDescribe.setText(describe);
        binding.txtName.setText(name);
        binding.imvImage.setImageBitmap(bitmap);

        binding.btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo dialog xác nhận
                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Lastest_RoomPost.this);
                builder.setTitle("Đăng bài");
                builder.setMessage("Bạn có chắc chắn muốn đăng bài không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Lưu dữ liệu vào database
                        db.insertData(type, name, sdt, address, square, numofpeople,gender, describe, image);
                        boolean check = db.insertData(type, name, sdt, address, square, numofpeople,gender, describe, image);
                        if (check == true) {
                            Toast.makeText(Activity_Lastest_RoomPost.this, "Vui lòng chờ admin duyệt bài!", Toast.LENGTH_SHORT).show();
                            // chờ 5s

                            dialogWait = new Dialog(Activity_Lastest_RoomPost.this);
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
                            Toast.makeText(Activity_Lastest_RoomPost.this, "Bài của bạn đã được duyệt, đăng bài thành công!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Activity_Lastest_RoomPost.this, HomePage.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Activity_Lastest_RoomPost.this, "Đăng bài không thành công, vui lòng thử lại!", Toast.LENGTH_SHORT).show();
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