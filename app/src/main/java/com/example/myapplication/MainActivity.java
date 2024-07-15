package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerDestination;
    private DatePicker datePicker;
    private EditText editTextBudget;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerDestination = findViewById(R.id.spinnerDestination);
        datePicker = findViewById(R.id.datePicker);
        editTextBudget = findViewById(R.id.editTextBudget);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Populate spinner with destinations
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.destinations_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDestination.setAdapter(adapter);

        // Handle spinner item selection
        spinnerDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedDestination = parent.getItemAtPosition(position).toString();
                // You can do something with the selected destination if needed
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        // Handle button click event
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = spinnerDestination.getSelectedItem().toString();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1; // Month is 0-based, so add 1
                int year = datePicker.getYear();
                String date = day + "/" + month + "/" + year;
                String budget = editTextBudget.getText().toString();

                // Pass data to the next activity to display
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("destination", destination);
                intent.putExtra("date", date);
                intent.putExtra("budget", budget);
                startActivity(intent);
            }
        });
    }
}
