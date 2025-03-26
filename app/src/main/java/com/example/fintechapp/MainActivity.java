package com.example.fintechapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        TextView resultText = findViewById(R.id.result);
        Button calculateButton = findViewById(R.id.calculate_button);
        EditText textInput = findViewById(R.id.text_input);
        Spinner dropdownMenu = findViewById(R.id.dropdown_menu);

        String[] spinnerOptions = new String[] {
                getString(R.string.count_words),
                getString(R.string.count_characters)
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownMenu.setAdapter(adapter);

        dropdownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = spinnerOptions[position];
                if (getString(R.string.count_words).equals(selectedOption)) {
                    calculateButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String inputText = textInput.getText().toString();
                            if (TextUtils.isEmpty(inputText.trim())) {
                                Toast.makeText(MainActivity.this, getString(R.string.empty_input_message), Toast.LENGTH_SHORT).show();
                            } else {
                                resultText.setText(String.valueOf("Result: "+ TextCounter.countWords(inputText)));
                            }
                        }
                    });
                } else if (getString(R.string.count_characters).equals(selectedOption)) {
                    calculateButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String inputText = textInput.getText().toString();
                            if (TextUtils.isEmpty(inputText.trim())) {
                                Toast.makeText(MainActivity.this, getString(R.string.empty_input_message), Toast.LENGTH_SHORT).show();
                            } else {
                                resultText.setText(String.valueOf("Result: "+ TextCounter.countCharacters(inputText)));
                            }
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                resultText.setText("");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}