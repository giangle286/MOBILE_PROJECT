package com.example.models;

public class Notification {
    int notificationThumb;
    String notificationTitle;

    public int getNotificationThumb() {
        return notificationThumb;
    }

    public void setNotificationThumb(int notificationThumb) {
        this.notificationThumb = notificationThumb;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public Notification(int notificationThumb, String notificationTitle) {
        this.notificationThumb = notificationThumb;
        this.notificationTitle = notificationTitle;
    }
//    private String Notification;
//
//    public Notification(String notification) {
//        Notification = notification;
//    }
//
//    public String getNotification() {
//        return Notification;
//    }
//
//    public void setNotification(String notification) {
//        Notification = notification;
//    }
}
