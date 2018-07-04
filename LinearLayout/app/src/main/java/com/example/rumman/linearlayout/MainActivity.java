package com.example.rumman.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] Titles = {"Hello0", "Hello1","Hello2", "Hello3"};
    private ListView listv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listv = (ListView) findViewById(R.id.mylist);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), Titles);
        listv.setAdapter((ListAdapter) adapter);


        listv.setOnClickListener(new AdapterView() );

    }


}
