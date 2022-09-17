package com.hskdeveloper.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
TextView set_name,set_salary,set_age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setTitle("EmployeeDummy");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.dark_grey)));

        String name = getIntent().getStringExtra("name");
        String salary = getIntent().getStringExtra("salary");
        String age = getIntent().getStringExtra("age");

        set_name = findViewById(R.id.set_name);
        set_salary = findViewById(R.id.set_salary);
        set_age = findViewById(R.id.set_age);

        set_name.setText(name);
        set_salary.setText(salary);
        set_age.setText(age);
    }
}