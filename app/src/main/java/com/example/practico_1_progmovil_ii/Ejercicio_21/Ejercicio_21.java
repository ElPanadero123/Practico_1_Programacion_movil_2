package com.example.practico_1_progmovil_ii.Ejercicio_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico_1_progmovil_ii.R;

public class Ejercicio_21 extends AppCompatActivity {

    private EditText number1EditText;
    private EditText number2EditText;
    private Button startButton;
    private TextView resultTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio21);

        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        startButton = findViewById(R.id.startButton);
        resultTextView = findViewById(R.id.resultTextView);
        handler = new Handler(Looper.getMainLooper());

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCalculation();
            }
        });
    }

    private void startCalculation() {
        final int number1 = Integer.parseInt(number1EditText.getText().toString());
        final int number2 = Integer.parseInt(number2EditText.getText().toString());

        // Create a thread to calculate the MCD of two numbers
        Thread mcdThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final int result = calculateMCD(number1, number2);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        resultTextView.setText("MCD of " + number1 + " and " + number2 + " = " + result);
                    }
                });
            }
        });

        mcdThread.start();
    }

    private int calculateMCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculateMCD(b, a % b);
        }
    }
}
