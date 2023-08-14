package com.example.practico_1_progmovil_ii.Ejercicio_25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico_1_progmovil_ii.R;

public class Ejercicio_25 extends AppCompatActivity {
    private EditText inputEditText;
    private Button startButton;
    private TextView resultTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio25);

        inputEditText = findViewById(R.id.inputEditText);
        startButton = findViewById(R.id.startButton);
        resultTextView = findViewById(R.id.resultTextView);
        handler = new Handler(Looper.getMainLooper());

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputEditText.getText().toString();
                if (!input.isEmpty()) {
                    long number = Long.parseLong(input);
                    calculateSumOfDigits(number);
                } else {
                    resultTextView.setText("Please enter a number");
                }
            }
        });
    }

    private void calculateSumOfDigits(final long number) {
        Thread calculateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long sum = sumOfDigits(number);
                final String result = "Sum of digits: " + sum;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        resultTextView.setText(result);
                    }
                });
            }
        });

        calculateThread.start();
    }

    private long sumOfDigits(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
