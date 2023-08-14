package com.example.practico_1_progmovil_ii.Ejercicio_7;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.practico_1_progmovil_ii.R;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private static final int NOTIFICATION_ID = 1; // ID de la notificación
    private int count = 0;
    private Handler handler;
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                String content = "Service Running: " + count + " seconds";
                showNotification(content);
                count++;
                handler.postDelayed(runnable, 1000);
            }
        };

        runnable = new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        };

        handler.postDelayed(runnable, 1000);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void showNotification(String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, content)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Service Notification")
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
