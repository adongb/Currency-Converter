package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FourthActivity extends AppCompatActivity {

    private ArrayList<String> myArray = new ArrayList<String>();
    private ArrayAdapter<String> myAdapter;
    private ListView myListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        myListView = findViewById(R.id.listView);

        myAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                myArray);
        myListView.setAdapter(myAdapter);

        FloatingActionButton floatButton = findViewById(R.id.floatButton);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
                Snackbar.make(view, "Added date and time to the list", Snackbar.LENGTH_LONG)
                        .setAction("Undo", undoOnClickListener).show();
            }
        });
    }

    View.OnClickListener undoOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            myArray.remove(myArray.size() -1);
            myAdapter.notifyDataSetChanged();
            Snackbar.make(view, "You have removed date and time from the list", Snackbar.LENGTH_LONG).show();
        }
    };

    private void addItem() {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US);
        myArray.add(dateFormat.format(new Date()));
        myAdapter.notifyDataSetChanged();
    }

}