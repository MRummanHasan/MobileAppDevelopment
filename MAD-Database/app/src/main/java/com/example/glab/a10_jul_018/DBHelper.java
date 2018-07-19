package com.example.glab.a10_jul_018;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
    public UserData getSingleUserData(int id) {
        SQLiteDatabase db = getReadableDatabase();

        //db.rawQuery("SELECT Name,Age FROM USERSDATA WhERE ID ="+id,null);
        String idInString = String.valueOf(id);

//        What this cursor do
        Cursor cursor = db.query("USERDATA", new String[]{"NAME", "AGE"}, "ID=?"
                , new String[]{idInString}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            UserData ud = new UserData(cursor.getString(cursor.getColumnIndex("NAME")),
            Integer.parseInt(cursor.getString(cursor.getColumnIndex("AGE"))));
            return ud;
        } else {
            return null;
        }
    }

    public long Delete_UserData(int id)
    {
//        db is initialise every time
            SQLiteDatabase db = getWritableDatabase();
//            ambiguous WHERE clause
            return db.delete("USERDATA","ID=?",new String[]{String.valueOf(id)});
    }
    public ArrayList<UserData> getAllUserData(){
        ArrayList<UserData> udlist = new ArrayList<UserData>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USERSDATA", null);

        if (cursor != null){
            while (cursor.moveToNext())
            {
                udlist.add(new UserData(cursor.getString(cursor.getColumnIndex("NAME")),
                        Integer.parseInt(cursor.getString(cursor.getColumnIndex("AGE")))));
            }
            return udlist;
        }
        else {
            return  null;
        }
    }

    public long Update_UserData(String OldName, String newName)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME",newName);
        return db.update("USERSDATA", cv,"NAME=?", new String[]{OldName});
    }


}
