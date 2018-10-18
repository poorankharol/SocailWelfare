package com.kharol.sociallabourwelfare.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.kharol.sociallabourwelfare.R;

public class SingleItemView extends Activity {
    // Declare Variables
    TextView txtname;
    TextView txtcategory;
    TextView txtplace;
    String name;
    String category;
    String place;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();
        // Get the results of rank
        name = i.getStringExtra("name");
        // Get the results of country
        category = i.getStringExtra("category");
        // Get the results of population
        place = i.getStringExtra("place");

        // Locate the TextViews in singleitemview.xml
        txtname = (TextView) findViewById(R.id.name);
        txtcategory = (TextView) findViewById(R.id.category);
        txtplace = (TextView) findViewById(R.id.place);

        // Load the results into the TextViews
        txtname.setText(name);
        txtcategory.setText(category);
        txtplace.setText(place);
    }
}