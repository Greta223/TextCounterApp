package com.example.fintechapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView myTextView = findViewById(R.id.myTextView);
        Button myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(view -> {
            myTextView.setText("Button Clicked!");
        });
        Button colorButton = findViewById(R.id.colorButton);
        colorButton.setOnClickListener(view -> {
            myTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}