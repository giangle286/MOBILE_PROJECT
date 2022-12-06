package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class PostRoommateDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "PostRoommate.db";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME = "RoomatePost";

    private static final String COL_P_ID = "P_Id";
    private static final String COL_P_TYPE = "P_Type";
    private static final String COL_P_NAME = "P_Name";
    private static final String COL_P_SDT = "P_SDT";
    private static final String COL_P_NOP = "P_NOfP";
    private static final String COL_P_GENDER = "P_Gender";
    private static final String COL_P_ADDRESS = "P_Address";
    private static final String COL_P_SQUARE = "P_Square";
    private static final String COL_P_DES = "P_Describe";
    private static final String COL_P_PHOTO = "P_Photo";

    public PostRoommateDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " (" + COL_P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_P_TYPE + " VARCHAR(20), " +
                COL_P_NAME + " VARCHAR(20), " +
                COL_P_SDT + " VARCHAR(10), " +
                COL_P_ADDRESS + " VARCHAR(100), " +
                COL_P_SQUARE + " VARCHAR(10), " +
                COL_P_NOP + " VARCHAR(10), " +
                COL_P_GENDER + " VARCHAR(10), " +
                COL_P_DES + " VARCHAR(100), " +
                COL_P_PHOTO + " BLOB)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String username, String email, String password) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = sqLiteDatabase.insert("postroommate", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public void queryExec(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db =getReadableDatabase();
        return db.rawQuery(sql, null);
    }
    // insert data
    public boolean insertData(String type, String name, String sdt, String address, String square, Double nop, String Gender, String des, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO "+ TBL_NAME + " VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, type);
            statement.bindString(2, name);
            statement.bindString(3, sdt);
            statement.bindString(4, address);
            statement.bindString(5, square);
            statement.bindDouble(6, nop);
            statement.bindString(7,Gender);
            statement.bindString(8, des);
            statement.bindBlob(9, photo);

            statement.executeInsert();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

