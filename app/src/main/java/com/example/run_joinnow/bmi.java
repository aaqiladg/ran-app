package com.example.run_joinnow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class bmi extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    EditText weight, height;
    TextView BMInum, BMIexp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        weight = findViewById(R.id.etWeight);
        height = findViewById(R.id.etHeight);
        BMInum = findViewById(R.id.txtNum);
        BMIexp = findViewById(R.id.txtExp);

        setSupportActionBar(toolbar);


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


    }

    public void CalculateBMI(View view) {
        String w = weight.getText().toString();
        String h = height.getText().toString();

        double weightValue = Double.parseDouble(w);
        double heightValue = Double.parseDouble(h) / 100;

        double bmi = weightValue / (heightValue * heightValue);

        if (bmi < 18.5) {
            BMInum.setText (Double.toString(bmi));
            BMIexp.setText("You're underweight :( ");
        } else if (bmi >= 18.5 || bmi <= 24.9) {
            BMInum.setText(Double.toString(bmi));
            BMIexp.setText("You're healthy!");
        } else if (bmi >= 25 || bmi <= 29.9) {
            BMInum.setText(Double.toString(bmi));
            BMIexp.setText("You're overweight!");
        } else {
            BMInum.setText(Double.toString(bmi));
            BMIexp.setText("You're obese");
        }
    }

    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                Intent hintent = new Intent(bmi.this, home.class);
                startActivity(hintent);
                break;
            case R.id.nav_workout:
                Intent intent = new Intent(bmi.this, GuidedWorkout.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                Intent myintent = new Intent(bmi.this, MainActivity.class);
                startActivity(myintent);
            case R.id.nav_profile:
                Intent pintent = new Intent(bmi.this, Profile.class);
                startActivity(pintent);
                break;
            case R.id.nav_bmi:
                Intent bintent = new Intent(bmi.this, bmi.class);
                startActivity(bintent);
                break;
            case R.id.nav_diet:
                Intent dintent = new Intent(bmi.this, DietRec.class);
                startActivity(dintent);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}