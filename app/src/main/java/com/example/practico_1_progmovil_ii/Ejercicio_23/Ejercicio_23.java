package com.example.practico_1_progmovil_ii.Ejercicio_23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico_1_progmovil_ii.R;

public class Ejercicio_23 extends AppCompatActivity {

    private EditText inputEditText;
    private Button startButton;
    private TextView resultTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio23);

        inputEditText = findViewById(R.id.inputEditText);
        startButton = findViewById(R.id.startButton);
        resultTextView = findViewById(R.id.resultTextView);
        handler = new Handler(Looper.getMainLooper());

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startReversal();
            }
        });
    }

    private void startReversal() {
        final String input = inputEditText.getText().toString();
        final String[] parts = input.split(",");

        // Create a thread to reverse the strings using recursion
        Thread reverseThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final String result = reverseStrings(parts, parts.length - 1);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        resultTextView.setText("Reversed strings: " + result);
                    }
                });
            }
        });

        reverseThread.start();
    }

    private String reverseStrings(String[] strings, int index) {
        if (index == 0) {
            return strings[0];
        }
        return strings[index] + "," + reverseStrings(strings, index - 1);
    }
}
