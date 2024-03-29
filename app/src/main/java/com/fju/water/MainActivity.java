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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Switch swch;
    private TextView mon;
    private TextView nextmon;
    double mon_money;
    double nextmon_money;
    private Button button;
    boolean isNext = false;
    private Spinner spinn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG, "onCreate:");
        mon = findViewById(R.id.month);
        spinn = findViewById(R.id.sp);
        //  nextmon = findViewById(R.id.next);
        button = findViewById(R.id.butt);
        swch = findViewById(R.id.sw);
   //  Log.d(TAG, "water");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degree();
            }
        });

        swch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView ty = findViewById(R.id.type);
                ty.setText(isNext?getString(R.string.every_other_month):getString(R.string.monthly));
            }
        });
        spinn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,getResources().getStringArray(R.array.cities)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause:");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume:");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop:");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart:");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart:");
    }

        public void degree () {
            String string = mon.getText().toString();
     //      String nextstring = nextmon.getText().toString();
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

//            } else if (!TextUtils.isEmpty(nextstring)) {
//                double degree = Double.parseDouble(nextmon.getText().toString());
//                if (degree >= 1 && degree <= 20) {
//                    nextmon_money = degree * 7.35;
//                } else if (degree >= 21 && degree <= 60) {
//                    nextmon_money = degree * 9.45 - 42;
//                } else if (degree >= 61 && degree <= 100) {
//                    nextmon_money = degree * 11.55 - 168;
//                } else if (degree >= 101) {
//                    nextmon_money = degree * 12.075 - 220.5;
//                }
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
