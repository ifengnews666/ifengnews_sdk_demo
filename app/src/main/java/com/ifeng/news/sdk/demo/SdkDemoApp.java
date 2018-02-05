package com.ifeng.news.sdk.demo;

import android.app.Application;

import com.ifeng.core.IfengEngine;

/**
 * Created by litao3 on 2018/1/29.
 */

public class SdkDemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new IfengEngine.Builder().
                setContext(this).setKey("5286").setProID("ifengnewslite")
                .setDataType("news_ex").builder();
    }
}
