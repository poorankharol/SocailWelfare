package com.kharol.sociallabourwelfare.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kharol.sociallabourwelfare.R;

import java.util.ArrayList;

public class ListViewSkill extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_skill);

        ListView lvs=(ListView)findViewById(R.id.lvs);
        ArrayList<String> labourfamily=new ArrayList<String>();
        labourfamily.add("Amrat                 Mason                     Vapi");
        labourfamily.add("Amrat                 Mason                     Vapi");
        labourfamily.add("Amrat                 Mason                     Vapi");
        labourfamily.add("Amrat                 Mason                     Vapi");
        labourfamily.add("Amrat                 Mason                     Vapi");
        labourfamily.add("Amrat                 Mason                     Vapi");
        labourfamily.add("Amrat                 Mason                     Vapi");
        labourfamily.add("Amrat                 Mason                     Vapi");
        labourfamily.add("Amrat                 Mason                     Vapi");







        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,labourfamily);

        lvs.setAdapter(arrayAdapter);


    }
}
