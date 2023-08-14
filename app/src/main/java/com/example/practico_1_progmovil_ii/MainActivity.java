package com.example.practico_1_progmovil_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practico_1_progmovil_ii.Ejercicio_1.Ejercicio_1;
import com.example.practico_1_progmovil_ii.Ejercicio_13.Ejercicio_13;
import com.example.practico_1_progmovil_ii.Ejercicio_17.Ejercicio_17;
import com.example.practico_1_progmovil_ii.Ejercicio_19.Ejercicio_19;
import com.example.practico_1_progmovil_ii.Ejercicio_21.Ejercicio_21;
import com.example.practico_1_progmovil_ii.Ejercicio_23.Ejercicio_23;
import com.example.practico_1_progmovil_ii.Ejercicio_25.Ejercicio_25;
import com.example.practico_1_progmovil_ii.Ejercicio_3.Ejercicio_3;
import com.example.practico_1_progmovil_ii.Ejercicio_5.Ejercicio_5;
import com.example.practico_1_progmovil_ii.Ejercicio_7.Ejercicio_7;
import com.example.practico_1_progmovil_ii.Ejercicio_9.Ejercicio_9;

public class MainActivity extends AppCompatActivity {
    private Button ejercicio1;
    private Button ejercicio3;
    private Button ejercicio5;
    private Button ejercicio7;
    private Button ejercicio9;
    private Button ejercicio11;
    private Button ejercicio13;
    private Button ejercicio15;
    private Button ejercicio17;
    private Button ejercicio19;
    private Button ejercicio21;
    private Button ejercicio23;
    private Button ejercicio25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ejercicio1= findViewById(R.id.button1);
        ejercicio3= findViewById(R.id.button2);
        ejercicio5= findViewById(R.id.button3);
        ejercicio7= findViewById(R.id.button4);
        ejercicio9= findViewById(R.id.button5);
        ejercicio11= findViewById(R.id.button6);
        ejercicio13= findViewById(R.id.button7);
        ejercicio15= findViewById(R.id.button8);
        ejercicio17= findViewById(R.id.button9);
        ejercicio19= findViewById(R.id.button10);
        ejercicio21= findViewById(R.id.button11);
        ejercicio23= findViewById(R.id.button12);
        ejercicio25= findViewById(R.id.button13);

        ejercicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_1.class);
                startActivity(intent);
            }
        });

        ejercicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_3.class);
                startActivity(intent);
            }
        });

        ejercicio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_5.class);
                startActivity(intent);
            }
        });

        ejercicio7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_7.class);
                startActivity(intent);
            }
        });

        ejercicio9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_9.class);
                startActivity(intent);
            }
        });

        ejercicio11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ejercicio13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_13.class);
                startActivity(intent);
            }
        });

        ejercicio15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ejercicio17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_17.class);
                startActivity(intent);
            }
        });

        ejercicio19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_19.class);
                startActivity(intent);
            }
        });

        ejercicio21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_21.class);
                startActivity(intent);
            }
        });

        ejercicio23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_23.class);
                startActivity(intent);
            }
        });

        ejercicio25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio_25.class);
                startActivity(intent);
            }
        });
    }
}