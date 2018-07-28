package com.example.hp.ciphertool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Decryption extends AppCompatActivity {

    Button btnBack,BtnDec;
    EditText EditCT, EditK,EditShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);
        btnBack = findViewById(R.id.button9);
        BtnDec = findViewById(R.id.btnDec);
        EditCT = findViewById(R.id.editCT);
        EditK = findViewById(R.id.editK);
        EditShow = findViewById(R.id.editShow);

        BtnDec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String CipherText = EditCT.getText().toString();
                        String Key = EditK.getText().toString();
                        DES des = new DES();
                        String DecrptedText = des.Decrypt(CipherText,Key);
                        EditShow.setText(DecrptedText);

                    }
                });



        btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Decryption.this,HomeActivity.class);
                        startActivity(intent);

                    }
                });
    }
}
