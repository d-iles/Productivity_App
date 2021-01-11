package com.example.ourfirstapp11a;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {

    private int pageNumber = 2;

    public ThirdFragment(int number) {
        pageNumber = number;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adding_tasks, container, false );
        TextView text = view.findViewById(R.id.text1);
        int total = pageNumber + 1;
        text.setText("Page " + total);
        return view;
    }
}