package com.example.ourfirstapp11a;

import java.util.Calendar;

public class Task {
    private int importance = 0;
    private String taskName;
    private Calendar dueDate;

    /* Add a calculator for importance/worthiness in this later,
    maybe add a parameter(s) as a starting point for calculator */

    // Creating the task object
    public Task(String taskName) {
        setTaskName(taskName);
    }

    // Create the task object, but with more parameters
    public Task(String taskName, Calendar dueDate, int importance) {
        setTaskName(taskName);
        setDueDate(dueDate);
        setImportance(importance);
    }


    public String getName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Calendar getDueDate() {
        if (dueDate == null) {
            return Calendar.getInstance();
        }
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getImportance() {
        return importance;
    }
}