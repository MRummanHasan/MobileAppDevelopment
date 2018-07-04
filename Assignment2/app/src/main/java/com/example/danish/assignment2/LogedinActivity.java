package com.example.danish.assignment2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class LogedinActivity extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logedin);
        tv = (TextView)findViewById(R.id.textview1);
        tv2 = (TextView)findViewById(R.id.textview2);
        SharedPreferences sp = getSharedPreferences("Users",MODE_PRIVATE);
        String str = sp.getString("U1","");
        String[] arr = str.split("\\|");
        tv.setText("Hi " + arr[2]);
        tv2.setText("User Type : " + arr[0]);

    }
}
