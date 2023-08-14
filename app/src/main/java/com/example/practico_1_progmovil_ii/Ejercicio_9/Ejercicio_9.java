package com.example.practico_1_progmovil_ii.Ejercicio_9;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practico_1_progmovil_ii.R;

public class Ejercicio_9 extends AppCompatActivity {
    private TextView timeTextView;
    private Button startButton, pauseButton, resetButton;
    private long startTime = 0L;
    private Handler handler;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio9);

        timeTextView = findViewById(R.id.timeTextView);
        startButton = findViewById(R.id.startButton);
        pauseButton = findViewById(R.id.pauseButton);
        resetButton = findViewById(R.id.resetButton);

        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                updateTimer();
            }
        };

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    startTime = System.currentTimeMillis();
                    isRunning = true;
                    startTimer();
                }
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
                startTime = 0L;
                timeTextView.setText("00:00:00");
            }
        });
    }

    private void startTimer() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    long currentTime = System.currentTimeMillis() - startTime;
                    handler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(1000); // Esperar un segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    private void updateTimer() {
        long currentTime = System.currentTimeMillis() - startTime;
        int hours = (int) (currentTime / 3600000);
        int minutes = (int) ((currentTime % 3600000) / 60000);
        int seconds = (int) ((currentTime % 60000) / 1000);
        timeTextView.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}
