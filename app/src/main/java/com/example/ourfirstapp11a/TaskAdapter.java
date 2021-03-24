package com.example.ourfirstapp11a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView dateTextView;
        public TextView importanceTextView;
        public TextView timeTextView;
        public TextView descriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.task_name);
            dateTextView = itemView.findViewById(R.id.task_date);
            importanceTextView = itemView.findViewById(R.id.task_importance);
            timeTextView = itemView.findViewById(R.id.task_time);
            descriptionTextView = itemView.findViewById(R.id.task_description);
        }
    }

    private List<Task> tasks;

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View taskView = inflater.inflate(R.layout.tasks, parent, false);

        ViewHolder viewHolder = new ViewHolder(taskView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, int position) {
        Task task = tasks.get(position);
        int[] dates = task.getDueDate();

        /* Adding the task's name, due date, and importance to the layout */
        TextView textViewName = holder.nameTextView;
        textViewName.setText(task.getName());

        /* Adding the date textview. I took the calendar object from the task and formatted it
        using SimpleDateFormat */
        TextView textViewDate = holder.dateTextView;
        textViewDate.setText("Due by: " + dates[1] + "/" + dates[2]);

        /* Adding the time textview. */
        TextView textViewTime = holder.timeTextView;

        String time = dates[3] + ":" + dates[4];
        SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");
        try {
            Date date = f24Hours.parse(time);
            SimpleDateFormat f12Hours = new SimpleDateFormat("h:ma");
            textViewTime.setText("at " + f12Hours.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /* Adding the importance textview. This might be changed later depending on how we want to
        handle the priority of tasks */
        TextView textViewImportance = holder.importanceTextView;
        textViewImportance.setText("Worthiness: " + task.getImportance());

        TextView textViewDescription = holder.descriptionTextView;
        textViewDescription.setText(task.getDescription());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
