package com.example.practico_1_progmovil_ii.Ejercicio_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private List<byte[]> images = new ArrayList<>();

    public ImageAdapter(Context context) {
        this.context = context;
    }

    public void addImage(byte[] imageData) {
        images.add(imageData);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        byte[] imageData = images.get(position);

        // Convierte el byte[] a un Bitmap (esto puede variar según tu implementación)
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);

        // Utiliza Glide para cargar y mostrar la imagen en el ImageView
        Glide.with(context)
                .load(bitmap) // Carga el Bitmap en Glide
                .into(imageView);

        return imageView;
    }
}
