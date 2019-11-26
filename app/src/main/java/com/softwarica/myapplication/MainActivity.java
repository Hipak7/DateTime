package com.softwarica.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView tvDOB;
    private TextView tvTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDOB = findViewById(R.id.tvdob);
        tvTime =findViewById(R.id.tvtimepicker);

        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            loadTime();
            }
        });
        tvDOB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                loadDatePicker();

            }
        });

    }

    private void loadTime(){
        final Calendar c= Calendar.getInstance();
        final int hour=c.get(Calendar.HOUR);
        final int minute =c.get(Calendar.MINUTE);
        final int second =c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                
                tvTime.setText("Time is" + hourOfDay + ":" + minute);    
            }
        },hour,minute, false);
        timePickerDialog.show();
    }
    private void loadDatePicker() {
        //Use the current date as  the default date  in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Toast.makeText(this, "Month" + month, Toast.LENGTH_SHORT).show();
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this, year, month, day
        );
        datePickerDialog.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month=month+1;
        String date = "Month/Day/Year: " + month  + "/" + dayOfMonth + "/" + year;
        tvDOB.setText(date);
    }
}
