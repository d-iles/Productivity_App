package com.example.ourfirstapp11a;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private static final int NUM = 4;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int pos) {
        switch(pos) {
            case 0:
                return new FirstFragment(0);
            case 1:
                return new SecondFragment(1);
            case 2:
                return new FirstFragment(2);
            case 3:
                return new FirstFragment(3);
            default:
                return new FirstFragment(0);
        }
    }

    @Override
    public int getItemCount() {
        return NUM;
    }


}
