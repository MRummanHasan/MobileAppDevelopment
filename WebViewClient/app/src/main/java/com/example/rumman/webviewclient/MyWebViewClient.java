package com.example.rumman.webviewclient;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.contains("http://lms.pafkiet.edu.pk")) {
            view.loadUrl(url);

            // TO SHOW NOTIFICATION; Title,Icon,Text are mandatory
            Notification.Builder notification = new Notification.Builder(MainActivity.cntxt);
            notification.setContentTitle("Title");
            notification.setSmallIcon(android.R.mipmap.sym_def_app_icon);
            notification.setContentText("Hello Friends");

            NotificationManager notificationManager = (NotificationManager) MainActivity.cntxt.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, notification.build());

        }else {

            return true;
        }
        return false;
    }
}
