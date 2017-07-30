package com.example.mfahad.listgridrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by M.FAHAD on 7/29/2017.
 */
public class recycler_view_activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private com.example.mfahad.listgridrecyclerview.Adapter adapter;
    private ArrayList<String> data;

    private Button insert;
    private EditText name;

    private Button Recycle ;
    private Button List;
    private  Button Grid;
    @Override
    protected void onCreate(Bundle bundle ){
        super.onCreate(bundle);
        setContentView(R.layout.recycler_view);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Recycler View");
        recyclerView =(RecyclerView) findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<String>();
        data.add("Asad");

        Recycle = (Button) findViewById(R.id.recycle);
        Recycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), recycler_view_activity.class);
                startActivity(i);
                finish();
            }
        });

        List = (Button) findViewById(R.id.list);
        List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), list_view_activity.class);
                startActivity(i);
                finish();
            }
        });
        Grid = (Button) findViewById(R.id.grid);
        Grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), grid_view_activity.class);
                startActivity(i);
                finish();
            }
        });
        Recycle.setBackgroundResource(R.drawable.button);

        adapter = new com.example.mfahad.listgridrecyclerview.Adapter(data , getApplicationContext());
        recyclerView.setAdapter(adapter);
        name = (EditText) findViewById(R.id.name) ;
        insert =(Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals("")) {
                    Toast.makeText(recycler_view_activity.this, "Enter the name", Toast.LENGTH_SHORT).show();
                } else {
                    String dat = name.getText().toString().trim();
                    // Condition to handle the Spaces
                    if (dat.equals("") || dat.equals(" ")) {
                        Toast.makeText(recycler_view_activity.this, "Enter the name", Toast.LENGTH_SHORT).show();
                    } else {
                        data.add(dat);
                        adapter.notifyDataSetChanged();
                        name.setText("");
                        //hideKeyboard();
                    }
                }
            }
        });

    }
}
