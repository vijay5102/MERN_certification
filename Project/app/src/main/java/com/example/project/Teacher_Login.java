package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Teacher_Login extends AppCompatActivity {

    EditText etid,etpwd;
    Button tlb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        etid = findViewById(R.id.tid);
        etpwd = findViewById(R.id.tpwd);
        tlb = findViewById(R.id.tl);

        tlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etid.getText().toString().equals("T_Mca") && etpwd.getText().toString().equals("mca@123")) {
                    Toast.makeText(Teacher_Login.this,"LOGIN SUCCESSFUL!",Toast.LENGTH_LONG).show();
                    Intent tdb = new Intent(getApplicationContext(), Teacher_Dashboard.class);
                    startActivity(tdb);
                }else{
                    Toast.makeText(Teacher_Login.this,"LOGIN FAILED!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}