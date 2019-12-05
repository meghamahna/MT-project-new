package com.example.megha_c0749456_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText dailyRent;
    SeekBar seekbar;
    int days;
    TextView daysNumber;
    RadioGroup radioGroup;
    CheckBox gps;
    CheckBox childSeat;
    CheckBox unlimitedMillage;
    TextView amount;
    TextView totalAmount;
    Button btn;
    double total;
    int temp = 0;
    int car_chosen = 0;
    int radioId = 0;
    int days_selected = 0;

    double daily_rent;
    double rent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        dailyRent = findViewById(R.id.dailyRent);
        seekbar = findViewById(R.id.seekbar);
        daysNumber = findViewById(R.id.daysNumber);
        radioGroup = findViewById(R.id.radioGroup);
        gps = findViewById(R.id.gps);
        childSeat = findViewById(R.id.childSeat);
        unlimitedMillage = findViewById(R.id.millage);
        amount = findViewById(R.id.amount);
        totalAmount = findViewById(R.id.total);
        btn = findViewById(R.id.btn);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (spinner.getSelectedItem().toString()){

                    case "Please choose a car": dailyRent.setText("");
                                                break;
                    case "BMW": dailyRent.setText("200");
                                daily_rent = 200.0;
                                car_chosen = 1;
                                break;
                    case "Audi": dailyRent.setText("300");
                                 daily_rent = 300.0;
                                 car_chosen = 1;
                                 break;
                    case "Cadillac": dailyRent.setText("150");
                                     daily_rent = 150.0;
                                     car_chosen = 1;
                                     break;
                    case "Mercedes": dailyRent.setText("500");
                                     daily_rent = 500.0;
                                     car_chosen = 1;
                                     break;
                    case "Civic": dailyRent.setText("100");
                                  daily_rent = 200.0;
                                  car_chosen = 1;
                                  break;
                    case "Mazda": dailyRent.setText("350");
                                  daily_rent = 350.0;
                                  car_chosen = 1;
                                  break;
                    case "Accord": dailyRent.setText("120");
                                   daily_rent = 120.0;
                                   car_chosen = 1;
                                   break;
                    case "Sonata": dailyRent.setText("125");
                                   daily_rent = 125.0;
                                   car_chosen = 1;
                                   break;


                    default:
                        Toast.makeText(MainActivity.this, "Choose a car", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                days = progress;
                rent = days * daily_rent;
                daysNumber.setText(String.valueOf(days));
                days_selected = 1;

                if(spinner.getSelectedItem().toString() == "Please choose a car") {
                    Toast.makeText(MainActivity.this, "Select the car", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (car_chosen == 0) {
                    Toast.makeText(MainActivity.this, "Select car", Toast.LENGTH_SHORT).show();
                }

                else {

                    switch (checkedId) {

                        case R.id.age1:
                            rent += 5;
                            total = rent + (0.13 * rent);
                            amount.setText(String.valueOf(rent));
                            totalAmount.setText(String.valueOf(total));
                            radioId = 1;
                            break;
                        case R.id.age2:
                            rent = rent + 0;
                            total = rent + (0.13 * rent);
                            amount.setText(String.valueOf(rent));
                            totalAmount.setText(String.valueOf(total));
                            radioId = 2;
                            break;
                        case R.id.age3:
                            rent -= 10;
                            total = rent + (0.13 * rent);
                            amount.setText(String.valueOf(rent));
                            totalAmount.setText(String.valueOf(total));
                            radioId = 3;
                            break;
                    }
                }


            }
        });



        gps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                
                if(radioId == 0) {

                    Toast.makeText(MainActivity.this, "Select Age", Toast.LENGTH_SHORT).show();
                }

                else if(car_chosen == 0){
                    Toast.makeText(MainActivity.this, "Select Car", Toast.LENGTH_SHORT).show();
                }

                else if (isChecked) {
                        rent = rent + 5;
                        total = rent + (0.13 * rent);
                        amount.setText(String.valueOf(rent));
                        totalAmount.setText(String.valueOf(total));
                        temp = 1;

                    }
                }

        });

        childSeat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(radioId == 0) {

                    Toast.makeText(MainActivity.this, "Select Age", Toast.LENGTH_SHORT).show();
                }

                else if(car_chosen == 0){
                    Toast.makeText(MainActivity.this, "Select Car", Toast.LENGTH_SHORT).show();
                }
                   else if (isChecked) {
                        rent = rent + 7;
                        total = rent + (0.13 * rent);
                        amount.setText(String.valueOf(rent));
                        totalAmount.setText(String.valueOf(total));
                        temp = 1;
                    }
                }

        });

        unlimitedMillage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(radioId == 0) {

                    Toast.makeText(MainActivity.this, "Select Age", Toast.LENGTH_SHORT).show();
                }

                else if(car_chosen == 0){
                    Toast.makeText(MainActivity.this, "Select Car", Toast.LENGTH_SHORT).show();
                }
                   else if (isChecked) {
                        rent = rent + 10;
                        total = rent + (0.13 * rent);
                        amount.setText(String.valueOf(rent));
                        totalAmount.setText(String.valueOf(total));
                        temp = 1;
                    }

                }
        });

//        if (temp == 0){
//            rent = rent + 0;
//            total = rent + (0.13 * rent);
//            amount.setText(String.valueOf(rent));
//            totalAmount.setText(String.valueOf(total));
//        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioId == 0) {

                    Toast.makeText(MainActivity.this, "Select Age", Toast.LENGTH_SHORT).show();

                }

                else if (car_chosen == 0 ) {

                    Toast.makeText(MainActivity.this, "Select Car", Toast.LENGTH_SHORT).show();

                }

                else if (days_selected == 0) {

                    Toast.makeText(MainActivity.this, "Select Days", Toast.LENGTH_SHORT).show();

                }

                else {

                    if (daysNumber.getText().toString().isEmpty()) {

                        Toast.makeText(MainActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                    } else {

                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("name", spinner.getSelectedItem().toString());
                        intent.putExtra("days", daysNumber.getText().toString());

                        if (radioId == 1) {
                            intent.putExtra("age", "Less than 20");
                        } else if (radioId == 2) {
                            intent.putExtra("age", "Between 21 and 60");
                        } else if (radioId == 3) {
                            intent.putExtra("age", "Less than 20");
                        }

                        if (gps.isChecked()) {
                            intent.putExtra("gps", "true");
                        } else if (!gps.isChecked()) {
                            intent.putExtra("gps", "false");
                        }

                        if (childSeat.isChecked()) {
                            intent.putExtra("childSeat", "true");
                        } else if (!childSeat.isChecked()) {
                            intent.putExtra("childSeat", "false");
                        }

                        if (unlimitedMillage.isChecked()) {
                            intent.putExtra("unlimitedMillage", "true");
                        } else if (!unlimitedMillage.isChecked()) {
                            intent.putExtra("unlimitedMillage", "false");
                        }
                        intent.putExtra("amount", String.valueOf(rent));
                        intent.putExtra("total", String.valueOf(total));

                        startActivity(intent);
                    }

                }
            }
        });





    }
}


