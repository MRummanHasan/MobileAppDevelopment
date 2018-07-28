package com.example.rumman.webviewclient;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    public static Context cntxt;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = (WebView) findViewById(R.id.webviewBox);
        web.loadUrl("https.duckduckgo.com");
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
    }
}
