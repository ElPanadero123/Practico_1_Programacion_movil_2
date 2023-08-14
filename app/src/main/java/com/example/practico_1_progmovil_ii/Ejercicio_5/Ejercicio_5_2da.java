package com.example.practico_1_progmovil_ii.Ejercicio_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.practico_1_progmovil_ii.R;

public class Ejercicio_5_2da extends AppCompatActivity {
    private TextView textViewReceivedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio52da);

        textViewReceivedMessage = findViewById(R.id.textViewReceivedMessage);
        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra("message");
            if (message != null) {
                textViewReceivedMessage.setText("Received Message: " + message);

                // Ejemplo de ejecución de tarea asincrónica en un Thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Realizar tareas asincrónicas aquí
                        // Puedes enviar un mensaje al Handler para actualizar la interfaz de usuario
                    }
                }).start();
            }
        }

    }
}