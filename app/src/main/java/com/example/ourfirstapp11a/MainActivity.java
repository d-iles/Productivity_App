package com.example.ourfirstapp11a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ViewPager2 viewPager = (ViewPager2) findViewById(R.id.pager);
        //viewPager.setOffscreenPageLimit(1);
        CollectionDemoFragment cDF = new CollectionDemoFragment();
        //SwipeAdapter swipeAdapter = new SwipeAdapter();
        //viewPager.setAdapter(swipeAdapter);
        //viewPager.setCurrentItem(0);

    }
}