package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
     private TextView M ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        M = findViewById(R.id.Money);
        double Monfee =getIntent().getDoubleExtra("MonthWaterMoney",0);
        Log.d("ResultActivity", "MonthWaterMoney : "+Monfee);
        float money = (float)(Monfee+Monfee%.2f);
        M.setText(money+"");






    }
}
