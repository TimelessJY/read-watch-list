package com.example.zlcgh_000.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.main_activity);

        Button createButton = (Button) findViewById(R.id.create_button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CreateItemActivity.class);
                startActivity(myIntent);
                createItem(myIntent.getStringExtra("newItemName"),
                        myIntent.getBooleanExtra("newBook", true));
            }
        });
    }

    private void createItem(String itemName, boolean newBook){
        TextView newItem = new TextView(this);
        newItem.setText(itemName);
        newItem.setVisibility(View.VISIBLE);
        linearLayout.addView(newItem);
    }
}
