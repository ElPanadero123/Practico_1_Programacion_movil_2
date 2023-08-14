package com.example.practico_1_progmovil_ii.Ejercicio_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico_1_progmovil_ii.R;

public class Ejercicio_19 extends AppCompatActivity {

    private EditText nEditText;
    private Button startButton;
    private TextView resultTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio19);

        nEditText = findViewById(R.id.nEditText);
        startButton = findViewById(R.id.startButton);
        resultTextView = findViewById(R.id.resultTextView);
        handler = new Handler(Looper.getMainLooper());

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSumCalculation();
            }
        });
    }

    private void startSumCalculation() {
        final int n = Integer.parseInt(nEditText.getText().toString());

        // Create a thread to calculate the sum of the first n natural numbers
        Thread sumThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final int result = sumNaturals(n);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        resultTextView.setText("Sum of first " + n + " natural numbers = " + result);
                    }
                });
            }
        });

        sumThread.start();
    }

    private int sumNaturals(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumNaturals(n - 1);
        }
    }
}
