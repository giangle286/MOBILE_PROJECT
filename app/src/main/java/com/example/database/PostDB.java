package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class PostDB extends SQLiteOpenHelper {

    private static final int DB_VERSION =1;
    private static final String DB_NAME ="posts.sqlite";

    public static final String TBL_NAME = "Post";

    private static final String COL_P_ID ="P_Id";
    private static final String COL_P_Type = "P_Type";
    private static final String COL_P_NAME ="P_Name";
    private static final String COL_P_SDT ="P_SDT";
    private static final String COL_P_PRICE ="P_Price";
    private static final String COL_P_ADDRESS ="P_Address";
    private static final String COL_P_SQUARE = "P_Square";
    private static final Double COL_P_NOP = Double.valueOf("P_NOfP");
    private static final String COL_P_DES = "P_Describe";
    private static final String COL_P_PHOTO ="P_Photo";

    public PostDB (@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_P_Type + " VARCHAR(100), " +
                COL_P_NAME +  " VARCHAR(10), " +
                COL_P_SDT + " VARCHAR(10), " +
                COL_P_PRICE + " VARCHAR(10), " +
                COL_P_ADDRESS + " VARCHAR(100), " +
                COL_P_SQUARE + " VARCHAR(10), " +
                COL_P_NOP + " VARCHAR(10), " +
                COL_P_DES + "VARCHAR(100), " +
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

    public boolean insertData(String type, String name, String sdt, String price, String address, String square, double nop, String mota, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO "+ TBL_NAME + " VALUES(NULL, ?, ?, ?, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, type);
            statement.bindString(2, name);
            statement.bindString(3, sdt);
            statement.bindString(4, price);
            statement.bindString(5, address);
            statement.bindString(6, square);
            statement.bindDouble(7, nop);
            statement.bindString(8,mota);
            statement.bindBlob(9, photo);
            statement.executeInsert();
            return true;
        } catch (Exception e) {

            return false;
        }
    }
}
