package com.example.glab.a10_jul_018;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    private  static final String DB_Name = "MyDB" ;
    private  static final int DB_Ver = 1 ;

    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_Ver);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String script = "CREATE TABLE UsersData (ID INTEGER  PRIMARY KEY,NAME TEXT,AGE INTEGER)";
        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if EXISTS UsersData");
        onCreate(sqLiteDatabase);
    }
    public long Insert_UserData(UserData ud)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Name",ud.name);
        cv.put("Age",ud.age);
        return db.insert("UsersData",null,cv);
    }
}
