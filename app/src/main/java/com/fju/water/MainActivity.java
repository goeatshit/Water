package com.fju.water;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mon;
    private TextView nextmon;
    double mon_money;
    double nextmon_money;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mon = findViewById(R.id.month);
        nextmon = findViewById(R.id.next);
        button = findViewById(R.id.butt);
        Log.d("MainActivity", "water");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degree();
            }
        });
    }

        public void degree () {
            String string = mon.getText().toString();
            String nextstring = nextmon.getText().toString();
            if (!TextUtils.isEmpty(string)) {
                double degree = Double.parseDouble(mon.getText().toString());
                if (degree >= 1 && degree <= 10) {
                    mon_money = degree * 7.35;
                } else if (degree >= 11 && degree <= 30) {
                    mon_money = degree * 9.45 - 21;
                } else if (degree >= 31 && degree <= 50) {
                    mon_money = degree * 11.55 - 84;
                } else if (degree >= 51) {
                    mon_money = degree * 12.075 - 110.25;
                }
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("MonthWaterMoney",mon_money);
                startActivity(intent);

 /*               new AlertDialog.Builder(MainActivity.this)
                        .setTitle("You got a message")
                        .setMessage("Let's calculate your monthly water usage!" + "Fee"+":"+mon_money)
                        .setPositiveButton("SURE", null)
                        .show();
 */

            } else if (!TextUtils.isEmpty(nextstring)) {
                double degree = Double.parseDouble(nextmon.getText().toString());
                if (degree >= 1 && degree <= 20) {
                    nextmon_money = degree * 7.35;
                } else if (degree >= 21 && degree <= 60) {
                    nextmon_money = degree * 9.45 - 42;
                } else if (degree >= 61 && degree <= 100) {
                    nextmon_money = degree * 11.55 - 168;
                } else if (degree >= 101) {
                    nextmon_money = degree * 12.075 - 220.5;
                }
/*                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("You got a message")
                        .setMessage("Let's calculate your next monthly water usage!" + "Fee"+":"+nextmon_money)
                        .setPositiveButton("SURE", null)
                        .show();
            } else if (TextUtils.isEmpty(string) && TextUtils.isEmpty(nextstring)) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("You got a message")
                        .setMessage("You idiot")
                        .setPositiveButton("OK", null)
                        .show();

            }

 */
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
