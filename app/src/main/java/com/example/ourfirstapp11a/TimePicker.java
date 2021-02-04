package com.example.ourfirstapp11a;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.Calendar;

public class TimePicker {
    TextView timeButton;
    Context context;
    int tHour, tMinute;

    public TimePicker(TextView textView, Context context) {
        this.timeButton = textView;
        this.context = context;
        this.timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        context,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
                                //Initialize hour and minute
                                tHour = hourOfDay;
                                tMinute = minute;

                                Calendar calendar = Calendar.getInstance();
                                //Set hour and minute

                                calendar.set(0,0,0,tHour,tMinute);

                                String time = tHour+":"+tMinute;
                                timeButton.setText(time);
                            }
                        }, 12, 9, false
                );
                timePickerDialog.updateTime(tHour,tMinute);
                timePickerDialog.show();
            }
        });
    }

}
