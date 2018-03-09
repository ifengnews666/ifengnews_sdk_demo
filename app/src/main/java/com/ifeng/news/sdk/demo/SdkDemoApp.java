package com.ifeng.news.sdk.demo;

import android.app.Application;

import com.ifeng.core.DisplayConfiguration;
import com.ifeng.core.IfengEngine;

/**
 * Created by litao3 on 2018/1/29.
 */

public class SdkDemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        IfengEngine engine = new IfengEngine.Builder().
                setContext(this).setKey("5286").setProID("ifengnewslite")
                .setDataType("news_ex").builder();
        DisplayConfiguration configuration = engine.getConfiguration();
        configuration.setShowHead(false);
        configuration.setMenuBackgroundColorResID(R.color.colorPrimary);
        configuration.setTextUncheckedColorResID(android.R.color.white);
    }
}
