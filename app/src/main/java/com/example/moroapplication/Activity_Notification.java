<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Activity_Notification"
    android:orientation="vertical">

  <TextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="THÔNG BÁO"
      android:textSize="22sp"
      android:layout_gravity="left"
      android:textStyle="bold"
      android:textColor="@color/purple_700"
      android:layout_marginTop="15dp"
      android:layout_marginLeft="10dp"/>
  <LinearLayout
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:orientation="horizontal"
      android:padding="5dp"
      android:layout_marginTop="5dp">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Thông báo mới nhất "
        android:gravity="left"
        android:textStyle="bold"
        android:layout_marginLeft="10dp"/>

  </LinearLayout>
  <ListView
      android:id="@+id/lvNotification"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:layout_weight="1"
      android:divider="@drawable/divider"
      android:layout_marginTop="15dp"/>
  <com.google.android.material.bottomnavigation.BottomNavigationView
      android:id="@+id/menu_navigation"
      android:layout_width="match_parent"
      android:layout_height="50dp"
      app:itemIconTint="@color/purple_700"
      app:itemIconSize="30dp"
      app:labelVisibilityMode="unlabeled"
      app:itemTextColor="@color/black"
      app:layout_constraintBottom_toBottomOf="parent"
      app:layout_constraintEnd_toEndOf="parent"
      app:layout_constraintStart_toStartOf="parent"
      app:menu="@menu/bottom_nav_menu">
  </com.google.android.material.bottomnavigation.BottomNavigationView>


</LinearLayout>