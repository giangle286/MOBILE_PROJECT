package com.example.models;

public class MessageList {
    int messageThumb;
    String messageTitle;

    public int getMessageThumb() {
        return messageThumb;
    }

    public void setMessageThumb(int messageThumb) {
        this.messageThumb = messageThumb;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public MessageList(int messageThumb, String messageTitle) {
        this.messageThumb = messageThumb;
        this.messageTitle = messageTitle;
    }
}
