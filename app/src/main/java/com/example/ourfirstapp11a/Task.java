package com.example.ourfirstapp11a;

import java.util.Calendar;

public class Task {
    private String importance = "";
    private String taskName = "";
    private String description = "Default Description";
    private Calendar dueDate = null;

    /* Add a calculator for importance/worthiness in this later,
    maybe add a parameter(s) as a starting point for calculator */

    // Creating the task object
    public Task(String taskName) {
        setTaskName(taskName);
    }

    // Create the task object, but with more parameters
    public Task(String taskName, Calendar dueDate, String importance, String description) {
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

    public Calendar getDueDate() {
        if (dueDate == null) {
            return Calendar.getInstance();
        }
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
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