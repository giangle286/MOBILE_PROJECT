package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PostDecoDB extends SQLiteOpenHelper {
    private static final int DB_VERSION =1;
    private static final String DB_NAME ="decoposts.sqlite";

    public static final String TBL_NAME = "Post";

    private static final String COL_P_ID ="P_Id";
    private static final String COL_P_Type = "P_Type";
    private static final String COL_P_NAME ="P_Name";
    private static final String COL_P_PRICE ="P_Title";
    private static final String COL_P_DES = "P_Describe";
    private static final String COL_P_PHOTO ="P_Photo";
    public PostDecoDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
