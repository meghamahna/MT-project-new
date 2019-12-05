package com.example.megha_c0749456_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView name;
    TextView days;
    TextView age;
    TextView gps;
    TextView childSeat;
    TextView unlimitedMillage;
    TextView amount;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.carName);
        days = findViewById(R.id.days);
        age = findViewById(R.id.age);
        childSeat = findViewById(R.id.childSeat);
        unlimitedMillage = findViewById(R.id.millage);
        gps = findViewById(R.id.gps);
        amount = findViewById(R.id.amount);
        total = findViewById(R.id.total);

        Intent intent = getIntent();
        name.setText(intent.getExtras().getString("name"));
        days.setText(intent.getExtras().getString("days"));
        age.setText(intent.getExtras().getString("age"));
        gps.setText(intent.getExtras().getString("gps"));
        childSeat.setText(intent.getExtras().getString("childSeat"));
        unlimitedMillage.setText(intent.getExtras().getString("unlimitedMillage"));
        amount.setText(intent.getExtras().getString("amount"));
        total.setText(intent.getExtras().getString("total"));



    }
}
