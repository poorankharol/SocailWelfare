package com.kharol.sociallabourwelfare.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.kharol.sociallabourwelfare.R;
import com.kharol.sociallabourwelfare.adapter.ListViewAdapter;
import com.kharol.sociallabourwelfare.model.ListModel;

import java.util.ArrayList;
import java.util.Locale;

public class ListViewLabour extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_labour);
        ListView list;
        final ListViewAdapter adapter;
        final EditText editsearch;
        String[] name;
        String[] category;
        String[] place;
        ArrayList<ListModel> arraylist = new ArrayList<ListModel>();

            // Generate sample data
            name = new String[] { "Suresh", "Ravia", "Gulab", "Bhiku", "Natu", "Ramesh", "Ganesh", "Shivaji", "Kamlesh", "Umesh" };

            category = new String[] { "Mason", "Electrician", "Plumber",
                    "Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh",
                    "Russia", "Japan" };

            place = new String[] { "Vapi", "Valsad",
                    "Dadra", "Silvassa", "Sarigam", "Silvassa",
                    "Bhilad", "Nanaponda", "Vapi", "Udwada" };
         //Integer[] drawableArray = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};

        // Locate the ListView in listview_main.xml
            list = (ListView) findViewById(R.id.listviewlabour);

            for (int i = 0; i < name.length; i++)
            {
                ListModel wp = new ListModel(name[i], category[i],
                        place[i]);
                // Binds all strings into an array
                arraylist.add(wp);
            }

            // Pass results to ListViewAdapter Class
            adapter = new ListViewAdapter(this, arraylist);

            // Binds the Adapter to the ListView
            list.setAdapter(adapter);

            // Locate the EditText in listview_main.xml
            editsearch = (EditText) findViewById(R.id.search);

            // Capture Text in EditText
            editsearch.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub
                    String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                    adapter.filter(text);
                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1,
                                              int arg2, int arg3) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                    // TODO Auto-generated method stub
                }
            });
        }

        // Not using options menu in this tutorial

        }
