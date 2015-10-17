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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createButton = (Button) findViewById(R.id.create_button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CreateItemActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0 && resultCode == RESULT_OK){
            String temp = data.getStringExtra("newItemName");
            createItem(temp,
                    data.getBooleanExtra("newBook", true));

            System.out.println("------------------");
            System.out.println(temp);
        }
    }

    private void createItem(String itemName, boolean newBook){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.main_activity);

        TextView newItem = new TextView(MainActivity.this);
        newItem.setText(itemName);
        newItem.setVisibility(View.VISIBLE);

        linearLayout.addView(newItem);
    }
}
