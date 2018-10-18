package com.kharol.sociallabourwelfare.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.kharol.sociallabourwelfare.fragment.CategoryFragment;
import com.kharol.sociallabourwelfare.fragment.HomeFragment;
import com.kharol.sociallabourwelfare.fragment.UnSkilledFragment;
import com.kharol.sociallabourwelfare.helper.BottomNavigationViewHelper;
import com.kharol.sociallabourwelfare.R;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            Intent i=null;
            Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment=new HomeFragment();
                    break;

                case R.id.navigation_category:
                    i =new Intent(MainActivity.this,ListViewLabour.class);
                    startActivity(i);
                    break;

                case R.id.navigation_location:
                    i =new Intent(MainActivity.this,MapsActivity.class);
                            startActivity(i);
                    break;

            }
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container,fragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.getMenu().getItem(0).setChecked(true);
        Fragment fragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment,fragment.getClass().getSimpleName()).addToBackStack(null).commit();
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




    }

}
