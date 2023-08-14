package com.example.practico_1_progmovil_ii.Ejercicio_17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico_1_progmovil_ii.R;

public class Ejercicio_17 extends AppCompatActivity {
    private Button startButton;
    private EditText numbersEditText;
    private TextView resultTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio17);

        startButton = findViewById(R.id.startButton);
        numbersEditText = findViewById(R.id.inputNumbers);
        resultTextView = findViewById(R.id.resultTextView);
        handler = new Handler(Looper.getMainLooper());

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFindingMaxNumber();
            }
        });
    }

    private void startFindingMaxNumber() {
        String input = numbersEditText.getText().toString();
        String[] numberStrings = input.split(",");
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i].trim());
        }

        // Create a thread to find the max number
        Thread findMaxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final int maxNumber = findMax(numbers, 0);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Update UI with the result
                        resultTextView.setText("Max Number: " + maxNumber);
                    }
                });
            }
        });

        findMaxThread.start();
    }

    private int findMax(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return numbers[index];
        }
        int maxRest = findMax(numbers, index + 1);
        return Math.max(numbers[index], maxRest);
    }
}
