package com.example.danish.assignment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    Spinner spinner;
    String[] acctypes = {"Admin","Student"};
    Button btn;
    EditText ed1;
    EditText ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        spinner = (Spinner)findViewById(R.id.mysp);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,acctypes);
        spinner.setAdapter(adapter);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!ed1.getText().toString().isEmpty() && !ed2.getText().toString().isEmpty()) {
                    SharedPreferences sp = getSharedPreferences("Users", MODE_PRIVATE);
                    Log.e("Reached", "");
                    String data = spinner.getSelectedItem().toString()+"|"+ed1.getText().toString()+"|"+ed2.getText();
                    sp.edit().putString("U1", data).commit();
                    Intent intent = new Intent(getApplicationContext(),LogedinActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Fill all the Feilds!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
