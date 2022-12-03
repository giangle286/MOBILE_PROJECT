package com.example.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.MessageList;
import com.example.models.Notification;
import com.example.moroapplication.R;

import java.util.ArrayList;

public class MessageListAdapter extends BaseAdapter {

        private Activity context;
        ArrayList<MessageList> messageLists;

        public MessageListAdapter(Activity context, ArrayList<MessageList> messageLists) {
            this.context = context;
            this.messageLists = messageLists;
        }

        @Override
        public int getCount() {
            return messageLists.size();
        }

        @Override
        public Object getItem(int i) {
            return messageLists.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            com.example.adapters.MessageListAdapter.ViewHolder holder;
            if(view == null){
                //Link item view
                holder = new com.example.adapters.MessageListAdapter.ViewHolder();
                LayoutInflater inflater = context.getLayoutInflater();
                view = inflater.inflate(R.layout.item_messagelist, null);
                holder.txtMessageList = view.findViewById(R.id.txt_messageList);
                holder.imvMessageList = view.findViewById(R.id.imv_messageList);
                view.setTag(holder);
            }else {
                holder = (com.example.adapters.MessageListAdapter.ViewHolder) view.getTag();

            }
            holder.txtMessageList.setText(messageLists.get(i).getMessageTitle());
            holder.imvMessageList.setImageResource(messageLists.get(i).getMessageThumb());
//
            return view;
        }

        public static class ViewHolder {
            TextView txtMessageList;
            ImageView imvMessageList;


        }
}
