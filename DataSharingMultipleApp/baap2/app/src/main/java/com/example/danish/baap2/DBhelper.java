package com.example.danish.baap2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {


    public DBhelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE USERS(ID INTEGER PRIMARY KEY,NAME TEXT,NUMBER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(sqLiteDatabase);
    }

    public long insertData(User user)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("NAME",user.name);
        val.put("NUMBER",user.phoneno);
        return db.insert("USERS",null,val);

    }
    public Cursor getAll()
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("USERS",new String[]{"NAME","NUMBER"},null,null,null,null,null);
        return cursor;
    }

}
