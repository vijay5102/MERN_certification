package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Teacher_Dashboard extends AppCompatActivity {

    Button TakeAtten,AddStd,ViewStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        TakeAtten = findViewById(R.id.tab);
        AddStd = findViewById(R.id.asb);
        ViewStd = findViewById(R.id.vsb);

        AddStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent asp = new Intent(getApplicationContext(), Add_Students.class);
                startActivity(asp);
            }
        });
        ViewStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(Teacher_Dashboard.this,view_students.class);
            startActivity(i);
            }
        });
    }
}