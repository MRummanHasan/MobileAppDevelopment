package com.example.rumman.asyncexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button Btn = findViewById(R.id.buttonBox);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Btn = findViewById(R.id.buttonBox);
        TextView txt = findViewById(R.id.txtBox);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public class RunAsyncTask extends AsyncTask<Integer, Integer, String> {

        @Override
        protected String doInBackground(Integer... integers) {
            for (int  i = 0; i < integers[0]; i++){
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
//                setProgress(i);
            }
            return "Execution Complete Successfully...";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}