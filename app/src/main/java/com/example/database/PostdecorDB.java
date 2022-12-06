package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import com.example.models.Decor;

public class PostdecorDB extends SQLiteOpenHelper {

    private static final int DB_VERSION =1;
    private static final String DB_NAME ="DecorPosts.db";

    public PostdecorDB (@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    public static final String TBL_NAME = "DecorPost";

    private static final String COL_D_ID ="D_Id";
    private static final String COL_D_PHOTO ="D_Photo";
    private static final String COL_D_NAME ="D_Name";
    private static final String COL_D_USER ="D_User";
    private static final String COL_D_TYPE ="D_Type";

    public PostdecorDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " (" + COL_D_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_D_PHOTO + " BLOB , " +
            COL_D_NAME +  " VARCHAR(20), " +
            COL_D_USER + " VARCHAR(10), " +
            COL_D_TYPE + " VARCHAR(100))";
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

    //insert data into database
    public boolean insertData(byte[] image,String name, String user, String type) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "INSERT INTO " + TBL_NAME + " VALUES (NULL, ?, ?, ?, ?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.clearBindings();
            statement.bindBlob(1, image);
            statement.bindString(2, name);
            statement.bindString(3, user);
            statement.bindString(4, type);
            statement.executeInsert();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public int numbOfRows(){
        Cursor cursor = getData("SELECT * FROM " + TBL_NAME);
        int count = cursor.getCount();
        cursor.close();
        return 0;
    }

    // tạo dữ liệu mẫu
    public void createSampleData(){
        if (numbOfRows() == 0) {
            insertData(null,"Đơn giản vẫn đẹp","Trúc Anh", String.valueOf(Decor.TYPE_HIENDAI));
            insertData(null,"Đơn giản","Trúc", String.valueOf(Decor.TYPE_HIENDAI));
            insertData(null,"Sang trạng, đẹp","Lan Anh", String.valueOf(Decor.TYPE_TOIGIAN));
        }
    }


}
