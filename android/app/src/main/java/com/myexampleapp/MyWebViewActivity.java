package com.myexampleapp;

import android.os.Bundle;
import com.facebook.react.ReactActivity;
import com.mywebview.MyWebView;
import android.content.Intent;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class MyWebViewActivity extends ReactActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        final MyWebView myWebView = new MyWebView(this, url);
        setContentView(myWebView);
    }

    public void onRedirect(String url) {
        getReactInstanceManager()
            .getCurrentReactContext()
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit("onRedirect", url);
    }
}