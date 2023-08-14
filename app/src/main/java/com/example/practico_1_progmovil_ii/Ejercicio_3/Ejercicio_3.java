package com.example.practico_1_progmovil_ii.Ejercicio_3;

import android.os.Bundle;

import android.os.Handler;

import android.os.Looper;

import android.os.Message;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practico_1_progmovil_ii.R;

import java.util.ArrayList;

import java.util.List;

public class Ejercicio_3 extends AppCompatActivity {
    private EditText messageEditText;
    private TextView chatTextView;
    private Button sendButton;
    private Handler uiHandler;
    private boolean isUpdatingChat = true;
    private List<String> conversation = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        messageEditText = findViewById(R.id.messageEditText);
        chatTextView = findViewById(R.id.chatTextView);
        sendButton = findViewById(R.id.sendButton);

        uiHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                String receivedMessage = (String) msg.obj;
                updateChat(receivedMessage);
            }
        };
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString();
                sendMessage(message);
                messageEditText.setText("");
            }
        });
        Thread updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isUpdatingChat) {
                    try {
                        // Simula una actualización cada segundo
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Simula recibir mensajes de otro dispositivo
                    if (!conversation.isEmpty()) {
                        String receivedMessage = conversation.remove(0);

                        // Notifica al hilo de la interfaz de usuario para actualizar el chat
                        Message uiMessage = uiHandler.obtainMessage();
                        uiMessage.obj = receivedMessage;
                        uiHandler.sendMessage(uiMessage);
                    }
                }
            }
        });
        updateThread.start();
    }
    private void sendMessage(final String message) {
        Thread senderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Simula enviar mensaje a otro dispositivo

                // Simula un retraso
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Agregar el mensaje enviado a la conversación
                String sentMessage = "Tú: " + message;
                conversation.add(sentMessage);

                // Simula recibir un mensaje en el otro dispositivo
                String receivedMessage = "Amigo: ¡Mensaje recibido!";

                // Notifica al hilo de la interfaz de usuario para actualizar el chat
                Message uiMessage = uiHandler.obtainMessage();
                uiMessage.obj = receivedMessage;
                uiHandler.sendMessage(uiMessage);
            }
        });
        senderThread.start();
    }
    private void updateChat(String message) {
        chatTextView.append(message + "\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Detener la actualización del chat al cerrar la actividad
        isUpdatingChat = false;
    }
}
