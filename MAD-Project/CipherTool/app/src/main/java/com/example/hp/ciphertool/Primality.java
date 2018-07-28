package com.example.hp.ciphertool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Primality extends AppCompatActivity {

    Button BtnBack,BtnCheck;
    EditText txtValue,txtResult;
    String strnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primality);

        BtnBack = findViewById(R.id.btnBack);
        BtnCheck = findViewById(R.id.button12);
        txtValue = findViewById(R.id.editText5);
        txtResult = findViewById(R.id.editText6);




        BtnCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ////////////

                        strnumber = txtValue.getText().toString();
                        int temp;
                        int number=0;
                        try{
                            number = Integer.parseInt(strnumber);
                        }catch (Exception e){
                            Log.d("-------MSG------",""+e);
                        }

                        boolean isPrime=true;
                        //Scanner scan= new Scanner(System.in);
                        //System.out.println("Enter any number:");
                        //capture the input in an integer
                        int num= number;
                        //scan.close();
                        for(int i=2;i<=num/2;i++)
                        {
                            temp=num%i;
                            if(temp==0)
                            {
                                isPrime=false;
                                break;
                            }
                        }
                        //If isPrime is true then the number is prime else not
                        if(isPrime)

                            txtResult.setText(num + " is a Prime Number");
                            //System.out.println(num + " is a Prime Number");
                        else

                            txtResult.setText(num + " is not a Prime Number");
                            //System.out.println();
                        //////////////

                    }
                });

        BtnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Primality.this,HomeActivity.class);
                        startActivity(intent);
                    }
                });
    }
}
