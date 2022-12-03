package com.example.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.models.GridviewTrohomepage;
import com.example.moroapplication.R;

import java.util.List;

public class GridviewTrohomepageAdapter extends ArrayAdapter<GridviewTrohomepage> {
    Activity context;
    int resource;
    List<GridviewTrohomepage> objects;

    public GridviewTrohomepageAdapter(@NonNull Activity context, int resource, @NonNull List<GridviewTrohomepage> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=this.context.getLayoutInflater();
        row=layoutInflater.inflate(this.resource, null);
        TextView tenphong=row.findViewById(R.id.txt_NameHomepage);
        TextView diachi=row.findViewById(R.id.txt_diachiphongtro);
        TextView giaphongtro=row.findViewById(R.id.txt_giaphongtro);
        ImageView hinhphong=row.findViewById(R.id.img_Nhatrohomepage);
        GridviewTrohomepage gridviewTrohomepage =this.objects.get(position);
        diachi.setText(gridviewTrohomepage.getDiachi());
        hinhphong.setImageResource(gridviewTrohomepage.getHinhphong());
        return row;
    }
}

