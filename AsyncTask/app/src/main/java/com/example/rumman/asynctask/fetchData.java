package com.example.rumman.asynctask;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * Project : Fetching data from API
 * Created by M Rumman Khan 07/25/2018
 */

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";

    @Override //background thread
    protected Void doInBackground(Void... voids) {
        try {
            // api url location
            URL url = new URL("https://www.metaweather.com/api/location/search/?query=london");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            // read data from string
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Title: " + JO.get("title") + "\n"+
                        "Location Type: " + JO.get("location_type") + "\n"+
                        "Where On Earth IDentifier: " + JO.get("woeid") + "\n"+
                        "Latitude, Longitude: " + JO.get("latt_long") + "\n";
//                        "Distance: " + JO.get("distance") + "\n"

                dataParsed = dataParsed + singleParsed;
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // UI thread
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.fdata.setText(this.dataParsed);
    }
}