package com.example.hp.ciphertool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;

public class random extends AppCompatActivity {

    Button BtnBack,ButtonShow;
    EditText EditS, EditE,EditShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        BtnBack = findViewById(R.id.btnBack);
        EditS = findViewById(R.id.editText);
        EditE = findViewById(R.id.editText4);
        EditShow = findViewById(R.id.editText7);
        ButtonShow = findViewById(R.id.button11);

        BtnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(random.this,HomeActivity.class);
                        startActivity(intent);
                    }
                });

        ButtonShow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int s , e;
                        s = Integer.parseInt(EditS.getText().toString());
                        e = Integer.parseInt(EditE.getText().toString());



                        Random rand = new Random();

                        int  n = rand.nextInt(e) + s;

                        EditShow.setText(String.valueOf(n));
                    }
                });
    }
}
