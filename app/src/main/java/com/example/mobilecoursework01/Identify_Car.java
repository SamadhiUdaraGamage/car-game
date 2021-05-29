package com.example.mobilecoursework01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Identify_Car extends AppCompatActivity {


    boolean timer = false;
    private ImageView imgview;
    private Button button;

    private TextView textView;
    private TextView countdowntxt;
    private int random_no = 0;
    Random r;


    // set car images
    Integer[] images = {
            R.drawable.alto,
            R.drawable.aqua,
            R.drawable.audi,
            R.drawable.axio,
            R.drawable.baleno,
            R.drawable.benz,
            R.drawable.bezza,
            R.drawable.bmw_3_serie,
            R.drawable.bmw_m4,
            R.drawable.bmw_x3,
            R.drawable.camry,
            R.drawable.celerio_x,
            R.drawable.corolla,
            R.drawable.grand_wagonr,
            R.drawable.honda_brv,
            R.drawable.honda_city,
            R.drawable.honda_civic,
            R.drawable.honda_hr_v,
            R.drawable.hondafit,
            R.drawable.jazz,
            R.drawable.maruti,
            R.drawable.nissan_gtr,
            R.drawable.nissan_terra,
            R.drawable.premio,
            R.drawable.prius,
            R.drawable.sunny,
            R.drawable.vezel,
            R.drawable.vitz,
            R.drawable.vivaelite,
            R.drawable.yaris

    };

    int pickedImage = 0, lastPicked = 0;
    Spinner spinner;
    CountDownTimer count_timer;
    boolean onStart = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify__car);

        //set title
        setTitle("Identify the Car Make");

        //set countdown timer
        timer = getIntent().getBooleanExtra("time",false);
        countdowntxt = findViewById(R.id.countdown_time);
        Log.d("xyz","Time :"+timer );
        if(timer){
            countdowntxt.setVisibility(View.VISIBLE);
             count_timer = new CountDownTimer(21000,1000) {

                @Override
                public void onTick(long l) {
                    Log.d("xyz","Time :"+l/1000 );
                    countdowntxt.setText("Time : "+l/1000);
                    if(l/1000 < 5){
                       countdowntxt.setTextColor(Color.RED);
                    }

                }

                //set countdown timer on finish method
                @Override
                public void onFinish() {
                    Log.d("xyz","Finished");
                    spinner.setEnabled(false);
                    button.setText("Next");
                    if(GVariables.car_names[pickedImage] == spinner.getSelectedItem()){
                        Log.d("xyz", "True");
                        textView.setVisibility(View.VISIBLE);
                        textView.setTextColor(Color.GREEN);
                        textView.setText("CORRECT!!!");
                    }else{
                        textView.setVisibility(View.VISIBLE);
                        textView.setTextColor(Color.RED);
                        textView.setText("WRONG!!!");
                        Log.d("xyz", "False");
                    }
                }
            }.start();
        }

        imgview = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.Car_Make);
        textView=(TextView)findViewById(R.id.txt_correct);


       // set spinner
         spinner = findViewById(R.id.spinner);
        @SuppressLint("ResourceType") ArrayAdapter adapter = new ArrayAdapter(this,  android.R.layout.simple_spinner_item, GVariables.car_names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!onStart) {
                    String text = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                count_timer.cancel();
                    if (GVariables.car_names[pickedImage] == spinner.getSelectedItem()) {
                        Log.d("xyz", "True");
                        textView.setVisibility(View.VISIBLE);
                        textView.setTextColor(Color.GREEN);
                        textView.setText("CORRECT!!!");
                    } else {
                        textView.setVisibility(View.VISIBLE);
                        textView.setTextColor(Color.RED);
                        textView.setText("WRONG!!!");
                        Log.d("xyz", "False");
                    }
                    button.setText("Next");
                }else{
                    onStart = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        r = new Random();


        //showRandomImg();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!button.getText().equals("Next")) {
                    do {
                        pickedImage = r.nextInt(images.length);
                    } while (pickedImage == lastPicked);


                    lastPicked = pickedImage;
                    imgview.setImageResource(images[pickedImage]);
                }
                else {
                    Intent intent = new Intent(Identify_Car.this, Identify_Car.class);
                    intent.putExtra("time",timer);
                    startActivity(intent);
                    finish();
                }


            }


        });

    }





}
