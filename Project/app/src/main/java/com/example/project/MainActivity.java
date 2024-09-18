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

public class MainActivity extends AppCompatActivity {
    Button ltb,lsb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ltb = findViewById(R.id.lit);
        lsb = findViewById(R.id.lis);

        ltb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ltp = new Intent(getApplicationContext(), Teacher_Login.class);
                startActivity(ltp);
            }
        });

        lsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lsp = new Intent(getApplicationContext(), Student_Login.class );
                startActivity(lsp);
            }
        });
    }
}