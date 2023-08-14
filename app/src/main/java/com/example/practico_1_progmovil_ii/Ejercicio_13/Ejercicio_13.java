package com.example.practico_1_progmovil_ii.Ejercicio_13;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;

import com.example.practico_1_progmovil_ii.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Ejercicio_13 extends AppCompatActivity {
    private List<String> tasks = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private Executor executor = Executors.newSingleThreadExecutor();
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio13);

        final EditText taskEditText = findViewById(R.id.taskEditText);
        Button addTaskButton = findViewById(R.id.addTaskButton);
        final Button deleteSelectedButton = findViewById(R.id.deleteSelectedButton);
        ListView taskListView = findViewById(R.id.taskListView);

        adapter = new TaskAdapter(this, tasks);
        taskListView.setAdapter(adapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                deleteSelectedButton.setVisibility(View.VISIBLE);
            }
        });

        deleteSelectedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition >= 0 && selectedPosition < tasks.size()) {
                    removeTask(selectedPosition);
                    selectedPosition = -1;
                    deleteSelectedButton.setVisibility(View.GONE);
                }
            }
        });

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String task = taskEditText.getText().toString();
                if (!task.isEmpty()) {
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            tasks.add(task);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                    taskEditText.setText("");
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    private void removeTask(final int position) {
        if (position >= 0 && position < tasks.size()) {
            final String removedTask = tasks.get(position);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    tasks.remove(position);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            });
        }
    }
    }
