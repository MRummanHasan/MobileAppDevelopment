package com.example.areeb.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Thread background = new Thread() {
            public void run() {
                try
                {
                    sleep(5000);
                    Intent i = new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e)
                {}
            }
        };
        background.start();
    }
}
