package com.example.danish.baap2;

import android.content.Context;
import android.database.Cursor;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText usr,phn;
    Button btn,btn2;
    static Context context;
    DBhelper dBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        usr  = (EditText)findViewById(R.id.name);
        phn = (EditText)findViewById(R.id.phone);
        btn = (Button) findViewById(R.id.insbutt);
        btn2 = (Button) findViewById(R.id.insbutt1);
        dBhelper = new DBhelper(this,"MYDB",1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               long n = dBhelper.insertData(new User(usr.getText().toString(),phn.getText().toString()));
                Toast.makeText(MainActivity.this, "WORKING" + n, Toast.LENGTH_SHORT).show();

            }
        });
        
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cs = dBhelper.getAll();
                
                if (cs != null)
                {
                    Toast.makeText(MainActivity.this, "WORKING" + cs.getCount(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "NOTWORKING", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
