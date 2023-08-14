package com.example.practico_1_progmovil_ii.Ejercicio_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.practico_1_progmovil_ii.R;

public class Ejercicio_5 extends AppCompatActivity {

    private EditText editTextMessage;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio5);

        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                sendMessageToSecondActivity(message);
            }
        });
    }
    private void sendMessageToSecondActivity(String message) {
        Intent intent = new Intent(Ejercicio_5.this, Ejercicio_5_2da.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}