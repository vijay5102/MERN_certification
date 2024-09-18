package com.example.project;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.CustomFloatAttributes;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class Add_Students extends AppCompatActivity {

    EditText Rollno,Name,Birth;
    Button Add,Select;
    String N,D;
    int i;
    SQLiteDatabase db;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);

        Rollno = findViewById(R.id.rno);
        Name = findViewById(R.id.sn);
        Birth = findViewById(R.id.dob);
        Add = findViewById(R.id.as);
        Select = findViewById(R.id.sdob);

        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog();
            }
        });

        builder = new AlertDialog.Builder(this);
        db = openOrCreateDatabase("DB", Context.MODE_PRIVATE,null);
        db.execSQL("Create table if not exists Students(Roll_No integer,Name varchar(20),D_O_B Date)");
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = Integer.parseInt(Rollno.getText().toString());
                N = Name.getText().toString();
                D = Birth.getText().toString();
                db.execSQL("Insert into Students values("+i+",'"+N+"','"+D+"')");
                builder.setMessage("Added Student Successfully!");
                builder.show();
            }
        });

    }

    private void opendialog(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Birth.setText(String.valueOf(year)+"-"+String.valueOf(month+1)+"-"+String.valueOf(day));
            }
        },2022,0,15);
        dialog.show();
    }
}