package com.ifeng.news.sdk.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ifeng.core.DisplayConfiguration;
import com.ifeng.core.IfengEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

public class BottomTabActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IfengEngine engine = new IfengEngine.Builder().
                setContext(this.getApplication()).setKey("5286").setProID("ifengnewslite")
                .setDataType("news_ex").builder();
        DisplayConfiguration configuration = engine.getConfiguration();
        configuration.setShowHead(false);
        configuration.setMenuBackgroundColorResID(R.color.colorPrimary);
        configuration.setTextUncheckedColorResID(android.R.color.white);

        setContentView(R.layout.activity_bottom_tab);
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(new MyPagerAdapter());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    class MyPagerAdapter extends PagerAdapter {

        private Map<Integer, View> mPages = new HashMap<>();

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mPages.get(position);
            if (view == null) {
                switch (position) {
                    case 0:
                        view = LayoutInflater.from(BottomTabActivity.this).inflate(R.layout.layout_home_tab, container, false);
                        break;
                    case 1:
                        view = LayoutInflater.from(BottomTabActivity.this).inflate(R.layout.layout_feeds_tab, container, false);
                        break;
                    case 2:
                        view = LayoutInflater.from(BottomTabActivity.this).inflate(R.layout.layout_notifications_tab, container, false);
                        break;
                }
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = mPages.remove(position);
            container.removeView(view);
        }

    }



}
