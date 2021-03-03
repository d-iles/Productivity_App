package com.example.ourfirstapp11a;

import java.util.Calendar;

public class Task {
    private int Importance;
    private String taskName;
    private Calendar dueDate;

    /* Add a calculator for importance/worthiness in this later,
    maybe add a parameter(s) as a starting point for calculator */
    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }
}
