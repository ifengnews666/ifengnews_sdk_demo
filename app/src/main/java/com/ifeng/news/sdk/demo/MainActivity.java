package com.ifeng.news.sdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ifeng.core.widget.parallax_viewpager.IfengSlideView;

/**
 * Created by litao3 on 2018/3/6.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showIfengNewsStyle(View view) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), IfengStyleNewsActivity.class);
        startActivity(intent);
    }

    public void showBlueStyle(View view) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), BlueStyleActivity.class);
        startActivity(intent);
    }

    public void showBlueStyleWithLogo(View view) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), BlueStyleWithLogoActivity.class);
        startActivity(intent);

    }
}
