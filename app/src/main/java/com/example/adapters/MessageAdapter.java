package com.example.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Message;
import com.example.moroapplication.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> messageList;
    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Message> list) {
        this.messageList = list;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        if( message == null ) {
            return;
        }
        holder.txtMessage.setText(message.getMessage());

    }

    @Override
    public int getItemCount() {

        if (messageList != null) {
            return messageList.size();
        }
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        private TextView txtMessage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMessage = itemView.findViewById(R.id.txt_message);
        }
    }
}
