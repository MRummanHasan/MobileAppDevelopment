package com.example.rumman.asynctask;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {
String data = "";
    @Override //background thread
    protected Void doInBackground(Void... voids) {
        try {
            // api url clocation
            URL url = new URL("https://www.metaweather.com/api/location/search/?query=london");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            // read data from string
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // UI thread
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.fdata.setText(this.data);
    }
}
