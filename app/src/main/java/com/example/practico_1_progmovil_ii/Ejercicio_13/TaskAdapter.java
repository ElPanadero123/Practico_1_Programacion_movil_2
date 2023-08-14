package com.example.practico_1_progmovil_ii.Ejercicio_13;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<String>{
    public TaskAdapter(Context context, List<String> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView taskTextView = convertView.findViewById(android.R.id.text1);
        taskTextView.setText(task);

        return convertView;
    }
}
