package com.ifeng.news.sdk.demo;

import android.app.Activity;
import android.os.Bundle;

import com.ifeng.core.DisplayConfiguration;
import com.ifeng.core.IfengEngine;

/**
 * Created by litao3 on 2018/3/7.
 */

public class BlueStyleWithLogoActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IfengEngine engine = new IfengEngine.Builder().
                setContext(this.getApplication()).setKey("5286").setProID("ifengnewslite")
                .setDataType("news_ex").builder();
        DisplayConfiguration configuration = engine.getConfiguration();
        configuration.setMenuBackgroundColorResID(R.color.colorPrimary);
        configuration.setTextUncheckedColorResID(android.R.color.white);
        configuration.setHeadTextColorResId(android.R.color.white);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ifeng_style_news);
    }
}
