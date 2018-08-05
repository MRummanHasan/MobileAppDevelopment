package com.example.hp.ciphertool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signin extends AppCompatActivity {

    Button BtnBack,CreateAc,Btn1;
    EditText Edit1,Edit2,Edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        BtnBack = findViewById(R.id.btnBack);
        //CreateAc = findViewById(R.id.createAc);
        Edit1 = findViewById(R.id.edit1);
        Edit2 = findViewById(R.id.edit2);
        Edit3 = findViewById(R.id.edit3);
        Btn1 = findViewById(R.id.btn1);


        BtnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Signin.this,HomeActivity.class);
                        startActivity(intent);
                    }
                });

        Btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String text = Edit1.getText().toString();

                    }
                });

    }
}
