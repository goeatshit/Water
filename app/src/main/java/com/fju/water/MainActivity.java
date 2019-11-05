package com.fju.water;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mon;
    private TextView nextmon;
    int mon_money;
    int nextmon_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mon = findViewById(R.id.month);
        nextmon = findViewById(R.id.next);
        try {
            mon_money = Integer.parseInt(mon.toString());
            nextmon_money = Integer.parseInt(nextmon.toString());

        }catch(Exception E){
            E.printStackTrace();
        }


        Log.d("MainActivity", "water");

    FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });
}

        public void degree (View view){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("You got a message")
                .setMessage("Let's calculate your  next monthly water usage!")
                .setPositiveButton("SURE", null)
                .show();
        if (TextUtils.isEmpty(mon.toString()) ) {
            if (nextmon_money >= 1 && nextmon_money <= 20) {
                double degree = nextmon_money * 7.35;
            } else if (nextmon_money >= 21 && nextmon_money <= 60) {
                double degree = nextmon_money * 9.45 - 42;
            } else if (nextmon_money >= 61 && nextmon_money <= 100) {
                double degree = nextmon_money * 11.55 - 168;
            } else if (nextmon_money >= 101) {
                double degree = nextmon_money * 12.075 - 220.5;
            }
        } else if (TextUtils.isEmpty(nextmon.toString()) ) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("You got a message")
                    .setMessage("Let's calculate your monthly water usage!")
                    .setPositiveButton("SURE", null)
                    .show();
            if (mon_money >= 1 && mon_money <= 10) {
                double degree = mon_money * 7.35;
            } else if (mon_money >= 11 && mon_money <= 30) {
                double degree = mon_money * 9.45 - 21;
            } else if (mon_money >= 31 && mon_money <= 50) {
                double degree = mon_money * 11.55 - 84;
            } else if (mon_money >= 51) {
                double degree = mon_money * 12.075 - 110.25;
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
