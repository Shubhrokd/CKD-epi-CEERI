package com.urbanmusleem.egfrcalculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RadioButton rbFemale, rbAfricanRace;
    EditText edAge, edCreatinine;
    TextView tvResultGfr, tvCkdStage;
    Button btnCalculate, btnReset;
    GfrCalculator gfrCalculator; CkdCategory ckdCategory;
    private double age, creatinine, genderConstant, raceConstant;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generatedCode();
        initView();
        buttonCode();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void generatedCode() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initView() {
        // declare all views to object
        rbFemale = findViewById(R.id.radioButton2);
        rbAfricanRace = findViewById(R.id.radioButton4);
        edAge = findViewById(R.id.editText1);
        edCreatinine = findViewById(R.id.editText2);
        tvResultGfr = findViewById(R.id.textView8);
        tvCkdStage = findViewById(R.id.textView9);
        btnCalculate = findViewById(R.id.button1);
        btnReset = findViewById(R.id.button2);
    }

    private void buttonCode() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Try again!!", Toast.LENGTH_LONG).show();

                if (rbFemale.isChecked()) {
                    genderConstant = 0.702;
                } else {
                    genderConstant = 1.0;
                }
                if (rbAfricanRace.isChecked()) {
                    raceConstant = 1.212;
                } else {
                    raceConstant = 1.0;
                }
                age = Double.parseDouble(edAge.getText().toString());
                creatinine = Double.parseDouble(edCreatinine.getText().toString());

                gfrCalculator = new GfrCalculator(age, creatinine, genderConstant, raceConstant);
                gfrCalculator.setAge(age);
                gfrCalculator.setCreatinine(creatinine);
                gfrCalculator.setGenderConstant(genderConstant);
                gfrCalculator.setRaceConstant(raceConstant);

                ckdCategory = new CkdCategory();

                result = (int) gfrCalculator.getGfrResult();
                gfrCalculator.setCkdResult(result);

                tvResultGfr.setText(String.valueOf(result));
                tvCkdStage.setText(String.valueOf(gfrCalculator.getGfrResult()));
                tvCkdStage.setText(ckdCategory.getCkdCategory(result));
            }


        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edAge.setText("");
                edCreatinine.setText("");
                tvResultGfr.setText("");
                tvCkdStage.setText("");
            }
        });
    }
}
