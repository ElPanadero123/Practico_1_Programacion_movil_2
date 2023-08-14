package com.example.practico_1_progmovil_ii.Ejercicio_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.GridView;

import com.example.practico_1_progmovil_ii.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ejercicio_1 extends AppCompatActivity {

    private GridView gridView;
    private ImageAdapter imageAdapter;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                byte[] imageData = (byte[]) msg.obj;
                imageAdapter.addImage(imageData);
                return true;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        gridView = findViewById(R.id.gridView);
        imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        // Simulación: URL de imágenes de ejemplo
        String[] imageUrls = {
                "https://cdn-icons-png.flaticon.com/256/10776/10776506.png",
                "https://styles.redditmedia.com/t5_7cgb3k/styles/profileIcon_f2n6smo3olaa1.jpg?width=256&height=256&frame=1&auto=webp&crop=256:256,smart&s=80a27bfa4f6881ef5306115c77851031acf45463",
                "https://cdn-icons-png.flaticon.com/256/10776/10776428.png",
                "https://image.shutterstock.com/image-vector/trick-treat-cute-cartoon-capybara-260nw-2168609629.jpg",
                "https://cdn-icons-png.flaticon.com/256/10776/10776420.png",
                "https://cdn-icons-png.flaticon.com/512/10776/10776518.png",
                "https://image.spreadshirtmedia.net/image-server/v1/mp/products/T1459A839MPA4459PT28D315202404W8000H10000/views/1,width=800,height=800,appearanceId=839,backgroundColor=F2F2F2/capibara-divertido-en-traje-capyitalism-capitalismo-pun-pegatina.jpg"
                // ... agregar más URLs aquí
        };

        for (final String imageUrl : imageUrls) {
            Thread downloadThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] imageData = downloadImage(imageUrl);
                        Message message = handler.obtainMessage(1, imageData);
                        handler.sendMessage(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            downloadThread.start();
        }
    }

    private byte[] downloadImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream input = connection.getInputStream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096]; // Tamaño del buffer
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        input.close();
        return output.toByteArray(); //
    }
}
