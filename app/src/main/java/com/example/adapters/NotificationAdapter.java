package com.example.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Notification;
import com.example.moroapplication.R;

import java.util.ArrayList;

public class NotificationAdapter extends BaseAdapter {

    private Activity context;
    ArrayList<Notification> notifications;

    public NotificationAdapter(Activity context, ArrayList<Notification> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    @Override
    public int getCount() {
        return notifications.size();
    }

    @Override
    public Object getItem(int i) {
        return notifications.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            //Link item view
            holder = new NotificationAdapter.ViewHolder();
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.itemlist_notification, null);
            holder.txtNotification = view.findViewById(R.id.txtNotification);
            holder.imvNotification = view.findViewById(R.id.imv_Notification);
            view.setTag(holder);
        }else {
            holder = (NotificationAdapter.ViewHolder) view.getTag();

        }
        holder.txtNotification.setText(notifications.get(i).getNotificationTitle());
        holder.imvNotification.setImageResource(notifications.get(i).getNotificationThumb());
//
        return view;
    }

    public static class ViewHolder {
        TextView txtNotification;
        ImageView imvNotification;


    }
}
