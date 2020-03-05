package com.mywebview;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.myexampleapp.MyWebViewActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;

public class MyWebView extends WebView {

    public MyWebView(MyWebViewActivity activity, String url) {
        super(activity);

        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);

        this.setWebViewClient(new CustomWebViewClient(activity));
        this.loadUrl(url);
    }
}

class CustomWebViewClient extends WebViewClient {
    MyWebViewActivity activity;

    public CustomWebViewClient(MyWebViewActivity ref) {
        this.activity = ref;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        activity.onRedirect(request.getUrl().toString());
        return false;
    }
}