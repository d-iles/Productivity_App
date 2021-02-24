package com.example.ourfirstapp11a;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class ThirdFragment extends Fragment {

    private int pageNumber = 2;

    TextView etDate; //
    EditText editText1, editText2; // Title, desc
    DatePickerDialog.OnDateSetListener setListener;

    public ThirdFragment(int number) {
        pageNumber = number;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adding_tasks, container, false );

        etDate = view.findViewById(R.id.et_date); // THis is the Date button
        Calendar calender = Calendar.getInstance();
        final int year = calender.get(Calendar.YEAR);
        final int month = calender.get(Calendar.MONTH);
        final int day = calender.get(Calendar.DAY_OF_MONTH);

        editText1 = view.findViewById(R.id.editText1); // This is the Title
        editText2 = view.findViewById(R.id.editText2); // This is the desc

        etDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editText1.clearFocus();
                editText2.clearFocus();
                DatePickerDialog datePicker = new DatePickerDialog(ThirdFragment.this.getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
                datePicker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePicker.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = month+"/"+dayOfMonth+"/"+year;
                etDate.setText(date);
            }
        };

        // TODO Add TimePicker back into ThirdFragment, remove separate class
        TimePicker time = new TimePicker(view.findViewById(R.id.et_hour),ThirdFragment.this.getContext());
        time.setListener();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                editText1.clearFocus();
                editText2.clearFocus();
            }
        });

        return view;
    }

    /* This method hides the keyboard */
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

}