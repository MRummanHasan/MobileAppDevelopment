package com.example.hp.ciphertool;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Encryption extends AppCompatActivity {

    Button btnBack,BtnEnc;
    EditText EditPT, EditK, EditShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);
        btnBack = findViewById(R.id.button9);
        EditPT = findViewById(R.id.editPT);
        EditK = findViewById(R.id.editK);
        BtnEnc = findViewById(R.id.btnEnc);
        EditShow = findViewById(R.id.editShow);

        btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Encryption.this,HomeActivity.class);
                        startActivity(intent);
                    }
                });

        BtnEnc.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View view) {
                        String plainText = EditPT.getText().toString();
                        String key = EditK.getText().toString();

                        DES des = new DES();
                        String encrptedText =  des.encrytion(plainText,key);
                        EditShow.setText(encrptedText);

                    }
                });
    }
}
