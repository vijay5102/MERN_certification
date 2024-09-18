package com.example.project;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class view_students extends AppCompatActivity {
SQLiteDatabase db;
TableLayout t1;
int count;
Cursor cursor;
TextView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);
        t1 = findViewById(R.id.tableview);
        list = findViewById(R.id.list);
        db = openOrCreateDatabase("DB",MODE_PRIVATE,null);
        cursor = db.rawQuery("SELECT * FROM Students", null);
        if(cursor != null && cursor.moveToFirst()){
            do {
                Resources r = getResources();
                float widthInDp = 100;
                float widthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,widthInDp,r.getDisplayMetrics());
                TableRow r1 = new TableRow(this);
                TextView RollNoTextview = new TextView(this);
                TextView NameTextview = new TextView(this);
                TextView DOBTextview = new TextView(this);
                RollNoTextview.setLayoutParams(new TableRow.LayoutParams((int)widthInPx, TableRow.LayoutParams.WRAP_CONTENT,1f));
                NameTextview.setLayoutParams(new TableRow.LayoutParams((int)widthInPx, TableRow.LayoutParams.WRAP_CONTENT,1f));
                DOBTextview.setLayoutParams(new TableRow.LayoutParams((int)widthInPx, TableRow.LayoutParams.WRAP_CONTENT,1f));
                String rollNo = cursor.getString(cursor.getColumnIndex("Roll_No"));
                String name = cursor.getString(cursor.getColumnIndex("Name"));
                String DOB = cursor.getString(cursor.getColumnIndex("D_O_B"));
                RollNoTextview.setText(rollNo);
                NameTextview.setText(name);
                DOBTextview.setText(DOB);
                RollNoTextview.setTextSize(TypedValue.COMPLEX_UNIT_PX, 75);
                NameTextview.setTextSize(TypedValue.COMPLEX_UNIT_PX, 75);
                DOBTextview.setTextSize(TypedValue.COMPLEX_UNIT_PX, 75);
                r1.addView(RollNoTextview);
                r1.addView(NameTextview);
                r1.addView(DOBTextview);
                t1.addView(r1);
            } while (cursor.moveToNext());
            cursor.close();
        }
    }
}