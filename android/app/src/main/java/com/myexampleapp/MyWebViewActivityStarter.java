package com.myexampleapp;

import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import android.content.Intent;

public class MyWebViewActivityStarter extends ReactContextBaseJavaModule {
    MyWebViewActivityStarter(ReactApplicationContext reactContext) {
        super(reactContext);
    }
  
    @Override
    public String getName() {
        return "MyWebViewActivityStarter";
    }

    @ReactMethod
    void openMyWebView(String url) {
        Intent intent = new Intent(getCurrentActivity(), MyWebViewActivity.class);
        intent.putExtra("url", url);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        getCurrentActivity().startActivity(intent);
    }
}