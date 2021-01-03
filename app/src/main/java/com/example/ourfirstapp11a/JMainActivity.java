/*package com.example.ourfirstapp11a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivityjava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(1);
        CollectionDemoFragment cDF = new CollectionDemoFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, cDF).commit();
        //getSupportFragmentManager().beginTransaction().add(R.id.page_fragment_layout, new FragmentPage());
        SwipeAdapter swipeAdapter = new SwipeAdapter(cDF);
        viewPager.setAdapter(swipeAdapter);
        //viewPager.setCurrentItem(0);

        //SwipeAdapter sA = new SwipeAdapter();
        //sA.createFragment(0);
        //sA.createFragment(1);
        //sA.createFragment(2);


    }
} */