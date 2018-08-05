package com.example.danish.baap2part1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xml.sax.ContentHandler;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lsview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lsview = findViewById(R.id.listview);
        ContentResolver csr = getContentResolver();

        ArrayList<String> cllist = new ArrayList<String>();

        Uri uri = Uri.parse("content://com.example.danish.baapprovider");

        Cursor cursor = csr.query(uri,null,null,null,null);

        while(cursor.moveToNext())
        {
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            String number = cursor.getString(cursor.getColumnIndex("NUMBER"));

            cllist.add(name + "\n" + number);
        }

        lsview.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,cllist));



    }
}
