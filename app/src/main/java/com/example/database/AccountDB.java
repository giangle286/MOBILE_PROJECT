package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AccountDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "Account.db";
    public static final int DB_VERSION = 1;

    public static final String TBL_NAME = "UserAccount";
    public static final String COL_ID = "UserID";
    public static final String COL_USERNAME = "UserName";
    public static final String COL_EMAIL = "UserEmail";
    public static final String COL_PASSWORD = "Password";
    public static final String COL_PHONE = "UserPhone";
    public static final String COL_ADDRESS = "UserAddress";
    public static final String COL_IMAGE = "UserImage";

    public AccountDB(@Nullable Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        String sql = "CREATE TABLE " + TBL_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_USERNAME + " VARCHAR(50), "
                + COL_EMAIL + " VARCHAR(50), "
                + COL_PASSWORD + " VARCHAR(10), "
                + COL_PHONE + " VARCHAR(20), "
                + COL_ADDRESS + " VARCHAR(50), "
                + COL_IMAGE + " BLOB)";
        MyDB.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(MyDB);
    }

    // SELECT
    public Cursor getData(String sql){
        SQLiteDatabase MyDB = getReadableDatabase();
        return MyDB.rawQuery(sql, null);
    }
    // INSERT, UPDATE, DELETE
    public void queryExec(String sql){
        SQLiteDatabase MyDB = getWritableDatabase();
        MyDB.execSQL(sql);
    }

    // insert data in to Account table
    public boolean insertData(String username, String email, String password, String phone, String address){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put(COL_PHONE, phone);
        contentValues.put(COL_ADDRESS, address);
        long result = MyDB.insert(TBL_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    //update password
    public boolean updatepassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_PASSWORD, password);
        Cursor cursor = MyDB.rawQuery("SELECT * FROM " + TBL_NAME + " WHERE " + COL_EMAIL + " = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            long result = MyDB.update(TBL_NAME, contentValues, "UserEmail=?", new String[]{email});
            if (result == -1)
                return false;
            else
                return true;
        } else {
            return false;
        }
    }

    //check email
    public boolean checkemail(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from " + TBL_NAME + " where " + COL_EMAIL + " = ?", new String[] {email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    //check email and password
    public boolean checkemailpassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from " + TBL_NAME + " where " + COL_EMAIL + " = ? and " + COL_PASSWORD + " = ?", new String[] {email, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    //get user id
    public String getuserid(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from " + TBL_NAME + " where " + COL_EMAIL + " = ?", new String[] {email});
        String userid = "";
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                userid = cursor.getString(0);
            }
        }
        return userid;
    }

}