package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class PostDB extends SQLiteOpenHelper {

    private static final int DB_VERSION =1;
    private static final String DB_NAME ="Posts.db";

    public PostDB (@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    public static final String TBL_NAME = "RentPost";

    private static final String COL_P_ID ="P_Id";
    private static final String COL_P_TYPE = "P_Type";
    private static final String COL_P_NAME ="P_Name";
    private static final String COL_P_SDT ="P_SDT";
    private static final String COL_P_PRICE ="P_Price";
    private static final String COL_P_ADDRESS ="P_Address";
    private static final String COL_P_SQUARE = "P_Square";
    private static final String COL_P_NOP = "P_NOfP";
    private static final String COL_P_DES = "P_Describe";
    private static final String COL_P_PHOTO ="P_Photo";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " (" + COL_P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_P_NAME +  " VARCHAR(20), " +
                COL_P_SDT + " VARCHAR(10), " +
                COL_P_PRICE + " VARCHAR(100), " +
                COL_P_ADDRESS + " VARCHAR(100), " +
                COL_P_SQUARE + " VARCHAR(10), " +
                COL_P_NOP + " VARCHAR(10), " +
                COL_P_DES + " VARCHAR(100), " +
                COL_P_PHOTO + " BLOB)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    public void queryExec(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db =getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    // insert data into database
    public boolean insertData(String type, String name, String sdt, String price, String address, String square, Double nop, String des, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO "+ TBL_NAME + " VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, type);
            statement.bindString(2, name);
            statement.bindString(3, sdt);
            statement.bindString(4, price);
            statement.bindString(5, address);
            statement.bindString(6, square);
            statement.bindDouble(7, nop);
            statement.bindString(8, des);
            statement.bindBlob(9, photo);

            statement.executeInsert();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // update data into database
    public boolean updateData(String id, String type, String name, String sdt, String price, String address, String square, Double nop, String des, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "UPDATE "+ TBL_NAME + " SET " + COL_P_TYPE + " = ?, " + COL_P_NAME + " = ?, " + COL_P_SDT + " = ?, " + COL_P_PRICE + " = ?, " + COL_P_ADDRESS + " = ?, " + COL_P_SQUARE + " = ?, " + COL_P_NOP + " = ?, " + COL_P_DES + " = ?, " + COL_P_PHOTO + " = ? WHERE " + COL_P_ID + " = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, type);
            statement.bindString(2, name);
            statement.bindString(3, sdt);
            statement.bindString(4, price);
            statement.bindString(5, address);
            statement.bindString(6, square);
            statement.bindDouble(7, nop);
            statement.bindString(8, des);
            statement.bindBlob(9, photo);
            statement.bindString(10, id);
            statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // đếm số dòng trong database
    public int numbOfRows(){
        Cursor cursor = getData("SELECT * FROM "+ TBL_NAME);
        int count  = cursor.getCount();
        cursor.close();
        return count;
    }

}
