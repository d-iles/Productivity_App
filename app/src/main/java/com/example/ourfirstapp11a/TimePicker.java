package com.example.ourfirstapp11a;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimePicker {
    TextView timeButton;
    Context context;
    int tHour, tMinute;

    /** constructor */
    public TimePicker(TextView textView, Context context) {
        this.timeButton = textView;
        this.context = context;
        /*this.timeButton.setOnClickListener(new View.OnClickListener() {
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
        });*/
    }

    /** This method sets the onclick listener for the time button. */
    public void setListener() {
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

                                calendar.set(0, 0, 0, tHour, tMinute);

                                String time = tHour + ":" + tMinute;
                                SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");
                                try {
                                        Date date = f24Hours.parse(time);
                                        SimpleDateFormat f12Hours = new SimpleDateFormat("hh:mm aa");
                                        timeButton.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 12, 9, false
                );
                timePickerDialog.updateTime(tHour, tMinute);
                timePickerDialog.show();
            }
        });
    }

}
