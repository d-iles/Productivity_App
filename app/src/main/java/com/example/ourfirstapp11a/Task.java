package com.example.ourfirstapp11a;

import java.util.Calendar;

public class Task {
    private String importance = "";
    private String taskName = "";
    private String description = "Default Description";
    private int[] dueDate = new int[5];

    /* Add a calculator for importance/worthiness in this later,
    maybe add a parameter(s) as a starting point for calculator */

    // Creating the task object
    public Task(String taskName) {
        setTaskName(taskName);
    }

    // Create the task object, but with more parameters
    public Task(String taskName, int[] dueDate, String importance, String description) {
        setTaskName(taskName);
        setDueDate(dueDate);
        setImportance(importance);
        setDescription(description);
    }


    public String getName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int[] getDueDate() { return dueDate; }

    public void setDueDate(int[] dueDate) {
        this.dueDate = dueDate;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getImportance() {
        return importance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}