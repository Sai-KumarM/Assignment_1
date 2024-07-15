package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class DisplayActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView textViewDestination = findViewById(R.id.textViewDestination);
        TextView textViewDate = findViewById(R.id.textViewDate);
        TextView textViewBudget = findViewById(R.id.textViewBudget);

        String destination = getIntent().getStringExtra("destination");
        String date = getIntent().getStringExtra("date");
        String budget = getIntent().getStringExtra("budget");
        textViewDestination.setText("Destination: " + destination);
        textViewDate.setText("Date: " + date);
        textViewBudget.setText("Budget: $" + budget);
    }
}
