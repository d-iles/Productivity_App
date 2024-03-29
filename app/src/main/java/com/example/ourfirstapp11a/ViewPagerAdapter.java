package com.example.ourfirstapp11a;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private static final int NUM = 3;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int pos) {
        switch(pos) {
            case 1:
                return new SecondFragment(1);
            case 2:
                return new ThirdFragment(2);
            default:
                return new FirstFragment(0); // includes pos = 0
        }
    }

    @Override
    public int getItemCount() {
        return NUM;
    }


}