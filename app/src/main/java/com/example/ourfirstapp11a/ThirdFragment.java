package com.example.ourfirstapp11a;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
    When adding new TextViews or objects to this code, remember that we have added a workaround to be
    able to un-select textViews when clicking anywhere else on the screen. In order to apply the
    workaround you must have an onclickListener for the object and add the clearFocus/hide-keyboard code.
    Additionally, new TextViews must be added to the clearFocus method.
 */

public class ThirdFragment extends Fragment {

    private int pageNumber = 2;

    TextView submitButton; // This is the button that submits everything to the list
    AutoCompleteTextView aCTV; // This holds Priority

    TextView dateButton; // This is the Date button
    TextView timeButton; // This is the hour, minute button
    EditText editText1, editText2; // Title, desc
    int tYear, tMonth, tDay, tHour, tMinute; // Hour, minute for picking time
    Calendar taskSelection = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener setListener; // Used for picking Date

    /** constructor for ThirdFragment */
    public ThirdFragment(int number) {
        pageNumber = number;
    }

    /** onCreate occurs before onCreateView */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /** onCreateView is called to have the fragment instantiate its user interface view. */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adding_tasks, container, false );

        dateButton = view.findViewById(R.id.et_date);
        timeButton = view.findViewById(R.id.et_hour);
        Calendar calender = Calendar.getInstance();
        final int year = calender.get(Calendar.YEAR);
        final int month = calender.get(Calendar.MONTH);
        final int day = calender.get(Calendar.DAY_OF_MONTH);

        editText1 = view.findViewById(R.id.editText1);
        editText2 = view.findViewById(R.id.editText2);

        // This onclick listener controls the dateButton behavior
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFocus();
                DatePickerDialog datePicker = new DatePickerDialog(ThirdFragment.this.getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
                datePicker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePicker.show();
            }
        });

        // Sets the settings for the listener on the DatePickerDialog object
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tMonth = month;
                month = month+1;
                tYear = year;
                tDay = dayOfMonth;
                String date = month+"/"+dayOfMonth+"/"+year;
                dateButton.setText(date);
            }
        };

        // This onclick listener controls the timeButton behavior
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                clearFocus();
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        ThirdFragment.this.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
                                //Initialize hour and minute
                                tHour = hourOfDay;
                                tMinute = minute;
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

        // onClick view, hide keyboard and clear focus from textViews
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                clearFocus();
            }
        });

        aCTV= view.findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> aAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.dropdown_item, getResources().getStringArray(R.array.Priority));
        aCTV.setAdapter(aAdapter);

        aCTV.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                clearFocus();
                aCTV.showDropDown();
            }
        });

        submitButton = view.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                clearFocus();

                taskSelection.set(tYear, tMonth, tDay,tHour,tMinute); // sets the calender object
                Task current = new Task(editText1.getText().toString(),taskSelection,aCTV.getText().toString(),editText2.getText().toString());
                FirstFragment.addTask(current);

                editText1.setText("");
                editText2.setText("");
                timeButton.setText("");
                dateButton.setText("");
                aCTV.setText("Must");
                taskSelection.clear();
                tYear = 0;
                tMonth = 0;
                tDay = 0;
                tHour = 0;
                tMinute = 0;

            }
        });

        return view;
    }

    /** This method hides the keyboard */
    public void hideSoftKeyboard() {
        // TODO Add try-catch perhaps?
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = getActivity().getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(((Activity)this.getContext()));
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /** This method clears the focus from all the TextViews */
    public void clearFocus() {
        editText1.clearFocus();
        editText2.clearFocus();
        aCTV.clearFocus();
    }

}