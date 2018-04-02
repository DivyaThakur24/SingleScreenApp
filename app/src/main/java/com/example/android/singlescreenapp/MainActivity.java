package com.example.android.singlescreenapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

       FragmentManager fragmentManager;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content,new HomeFragment()).commit();
        }



        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();                

            switch(item.getItemId()){

                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.content,new HomeFragment()).commit();
                    break;
                case R.id.navigation_dashboard:
                    fragmentTransaction.replace(R.id.content,new DashboardFragment()).commit();                            
                    break;
                case R.id.navigation_notifications:
                    // do similarly        
                    break;

            }
            return loadFragment(fragment);
        }

}
