package com.example.datepickerdailog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button button;
    int Year_x,Month_x,Day_x;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar cal = Calendar.getInstance();
        Year_x = cal.get(Calendar.YEAR);
        Month_x = cal.get(Calendar.MONTH);
        Day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDialogDatePicker();
    }
    public void showDialogDatePicker(){
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_ID){
            return new DatePickerDialog(this,dPickerDialog,Year_x,Month_x,Day_x);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener dPickerDialog = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Year_x = year;
            Month_x = month;
            Day_x = dayOfMonth;

            Toast.makeText(MainActivity.this,Day_x + " / " + Month_x + " / " + Year_x,Toast.LENGTH_LONG).show();
        }
    };
}