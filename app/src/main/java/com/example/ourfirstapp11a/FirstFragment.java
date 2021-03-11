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

    ArrayList<Task> tasks = new ArrayList<>();

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

        Task task1 = new Task("Call Mom");
        Task task2 = new Task("Clean Room");
        Task task3 = new Task("Do Homework");
        Task task4 = new Task("Hang out with friends");
        Task task5 = new Task("Fix car");
        Task task6 = new Task("Sleep");



        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);


        TaskAdapter adapter = new TaskAdapter(tasks);

        rvTasks.setAdapter(adapter);

        rvTasks.setLayoutManager(new LinearLayoutManager(FirstFragment.this.getContext()));

        return view;
    }
}
