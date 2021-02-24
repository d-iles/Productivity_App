package com.example.ourfirstapp11a;

public class Task {
    private int Importance;
    private String taskName;

    /* Add a calculator for importance/worthiness in this later,
    maybe add a parameter(s) as a starting point for calculator */
    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getName() {
        return taskName;
    }
}
