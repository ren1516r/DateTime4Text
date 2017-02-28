package com.example.renjitha.datetime4text;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button btn_date,btn_time;
    EditText txtDate,txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_date=(Button)findViewById(R.id.btn_date);
        btn_time=(Button)findViewById(R.id.btn_time);

        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);

        btn_date.setOnClickListener(this);
        btn_time.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v==btn_date){
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);



            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                //    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                  /*  try {
                        Date target_date = sdf.parse(String.valueOf(txtDate.getText()));
                        Log.e("targetdate",String.valueOf(target_date));
                    } catch (ParseException e) {

                        e.printStackTrace();
                    }*/



                }
            },mYear,mMonth,mDay);

            datePickerDialog.show();

        }
        else{

            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);


            TimePickerDialog timePickerDialog= new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txtTime.setText(hourOfDay+" : "+minute);
                }
            },mHour,mMinute,false);
            timePickerDialog.show();
        }

    }
}
