package com.example.practico_1_progmovil_ii.Ejercicio_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practico_1_progmovil_ii.R;

public class Ejercicio_7 extends AppCompatActivity {
    private Button buttonStartService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio7);

        buttonStartService = findViewById(R.id.buttonStartService);

        buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(Ejercicio_7.this, MyService.class));

            }
        });
    }
}