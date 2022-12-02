package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.adapters.MessageListAdapter;
import com.example.adapters.NotificationAdapter;
import com.example.models.MessageList;
import com.example.models.Notification;

import java.util.ArrayList;

public class Activity_Message extends AppCompatActivity {

    ListView lvMessageList;
    ArrayList<MessageList> messageLists;
    MessageListAdapter messageListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        linkView();
        initData();
    }

    private void initData() {
        messageLists = new ArrayList<>();
        messageLists.add(new com.example.models.MessageList(R.drawable.loadingpage,"Moro Application"));
        messageListAdapter = new MessageListAdapter(Activity_Message.this,messageLists);
        lvMessageList.setAdapter(messageListAdapter);

    }

    private void linkView() {
        lvMessageList = findViewById(R.id.lv_messagesample);
    }
}