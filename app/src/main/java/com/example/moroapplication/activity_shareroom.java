package com.example.moroapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapters.ShareroomCategoryAdapter;
import com.example.adapters.TrohomepageCategoryAdapter;
import com.example.models.Shareroom;
import com.example.models.ShareroomCategory;

import java.util.ArrayList;
import java.util.List;

public class activity_shareroom extends AppCompatActivity {

    private RecyclerView rcvshareroomCategory;
    private ShareroomCategoryAdapter shareroomCategoryAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        rcvshareroomCategory=findViewById(R.id.rcv_homepageCategory);
        shareroomCategoryAdapter=new ShareroomCategoryAdapter(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvshareroomCategory.setLayoutManager(linearLayoutManager);
        shareroomCategoryAdapter.setData((getListShareroomCategory()));
        rcvshareroomCategory.setAdapter(shareroomCategoryAdapter);

    }


    private List<ShareroomCategory> getListShareroomCategory(){


        List<ShareroomCategory>listShareroomCategory=new ArrayList<>();
        List<Shareroom>shareroomList=new ArrayList<>();
        shareroomList.add(new Shareroom(R.drawable.img_nt1,R.drawable.img_nt1 ,"Phòng trọ Thủ Đức","17/4 Thủ Đức","20m2","2 triệu/tháng"));


        listShareroomCategory.add(new ShareroomCategory("Bài đăng mới nhất", shareroomList));
        listShareroomCategory.add(new ShareroomCategory("Xu hướng tìm kiếm", shareroomList));
        listShareroomCategory.add(new ShareroomCategory("Cho thuê phòng đôi", shareroomList));

        return listShareroomCategory;
    }

}
//<-->shareroom