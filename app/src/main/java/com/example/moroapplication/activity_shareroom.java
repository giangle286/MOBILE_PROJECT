package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapters.ShareroomCategoryAdapter;
import com.example.models.Shareroom;
import com.example.models.ShareroomCategory;

import java.util.ArrayList;
import java.util.List;

public class activity_shareroom extends AppCompatActivity {

    private RecyclerView rcvshareroomCategory;
    private ShareroomCategoryAdapter shareroomCategoryAdapter;
    private List<ShareroomCategory> getListShareroomCategory(){
        List<ShareroomCategory>listShareroomCategory=new ArrayList<>();
        List<Shareroom>shareroomList=new ArrayList<>();
        shareroomList.add(new Shareroom(R.drawable.img_nt3, R.drawable.ic_baseline_location_on_24,"Phòng trọ Thủ Đức","17/4 Thủ Đức","20m2","2 triệu/tháng"));


        listShareroomCategory.add(new ShareroomCategory("Bài đăng mới nhất", shareroomList));
        listShareroomCategory.add(new ShareroomCategory("Xu hướng tìm kiếm", shareroomList));
        listShareroomCategory.add(new ShareroomCategory("Cho thuê phòng đôi", shareroomList));

        return listShareroomCategory;
    }

}
//<-->shareroom