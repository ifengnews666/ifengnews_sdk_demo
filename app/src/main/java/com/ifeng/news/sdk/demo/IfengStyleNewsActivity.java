package com.ifeng.news.sdk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.ifeng.core.DisplayConfiguration;
import com.ifeng.core.IfengEngine;

public class IfengStyleNewsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IfengEngine engine = new IfengEngine.Builder().
                setContext(this.getApplication()).setKey("5286").setProID("ifengnewslite")
                .setDataType("news_ex").builder();

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ifeng_style_news);
    }

}
