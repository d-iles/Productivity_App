package com.example.ourfirstapp11a;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private int pageNumber = 0;

    ArrayList<Task> tasks = new ArrayList<Task>();

    public FirstFragment(int number) {
        pageNumber = number;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_view_pager, container, false );
        //view.findViewById(R.id.text1).setText("" + pageNumber);

        RecyclerView rvTasks = view.findViewById(R.id.rvTasks);

        tasks.add(new Task("Call Mom"));
        tasks.add(new Task("Clean Room"));
        tasks.add(new Task("Do Homework"));
        tasks.add(new Task("Hang out with friends"));
        tasks.add(new Task("Fix car"));
        tasks.add(new Task("Sleep"));


        TaskAdapter adapter = new TaskAdapter(tasks);

        rvTasks.setAdapter(adapter);

        rvTasks.setLayoutManager(new LinearLayoutManager(FirstFragment.this.getContext()));

        return view;
    }
}
