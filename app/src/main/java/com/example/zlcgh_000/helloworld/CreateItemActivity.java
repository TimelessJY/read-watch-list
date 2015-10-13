package com.example.zlcgh_000.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Create Item Window.
 */
public class CreateItemActivity extends Activity {
    private boolean newBook = true;
    private RadioGroup newItemType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_create_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width * .5), (int)(height * .5));

        newItemType = (RadioGroup) findViewById(R.id.NewItemType);

        final Button button = (Button) findViewById(R.id.ConfirmCreateButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedId = newItemType.getCheckedRadioButtonId();
                switch (selectedId) {
                    case R.id.NewBookButton:
                        newBook = true;
                    case R.id.NewFilmButton:
                        newBook = false;
                }

                TextView textView = (TextView) findViewById(R.id.NewItemNameText);
                CharSequence itemName = textView.getText();
                //TODO: check string value
                getIntent().putExtra("newItemName", itemName);
                getIntent().putExtra("newBook", newBook);
                // MainActivity.createItem(itemName, newBook);
                finish();
            }
        });
    }
}
