package com.example.mobilecoursework01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Identify_Image extends AppCompatActivity {

    boolean timer = false;
    TextView car_type;
    int[] carSet_images;
    String[] carTypes;
    String rndType;
    int random_num;
    int car1,car2,car3;

    ImageView img1,img2,img3;
    Button next_btn;
    int random_num1,random_num2;
    TextView correct_text;
    int answer;
    private TextView countdowntxt;
    CountDownTimer count_timer;
    boolean onStart = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify__image);

        //set title
        setTitle("Identify the Car Image");

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

                    correct_text.setVisibility(View.VISIBLE);
                    correct_text.setText("WRONG !!!");
                    correct_text.setTextColor(Color.RED);
                    setClickableofImage();
                }
            }.start();
        }


        correct_text = findViewById(R.id.txt_correct);

        //set car images
        carSet_images = new int[]{
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
        carTypes = new String[]{"Suzuki", "Toyota", "Audi", "Toyota", "Suzuki","Mercedes","Perodua", "BMW", "BMW", "BMW", "Toyota","Suzuki", "Toyota", "Suzuki", "Honda", "Honda",
                "Honda", "Honda", "Honda", "Honda", "Suzuki","Nissan", "Nissan", "Toyota", "Toyota", "Nissan","Honda", "Toyota", "Perodua", "Nissan", "Toyota"};






        Random rand = new Random();
        random_num = rand.nextInt(carSet_images.length);

        car_type = findViewById(R.id.txt_type);
        rndType = carTypes[random_num];


        boolean selectone = false;

        while(!selectone) {
            random_num1 = rand.nextInt(carSet_images.length);
            if(random_num1 != random_num && !(rndType.equals(carTypes[random_num1]))){
                selectone = true;
            }
        }

        boolean selecttwo = false;

        while(!selecttwo) {
            random_num2 = rand.nextInt(carSet_images.length);
            if(random_num2 != random_num && (random_num1 != random_num2) && !(rndType.equals(carTypes[random_num2]))){
                selecttwo = true;
            }
        }

        car1 = carSet_images[random_num];
        car2 = carSet_images[random_num1];
        car3 = carSet_images[random_num2];

        answer = random_num%3;
        if(answer == 0){
            car1 = carSet_images[random_num];
            car2 = carSet_images[random_num1];
            car3 = carSet_images[random_num2];
        }else if(answer == 1){
            car1 = carSet_images[random_num1];
            car2 = carSet_images[random_num];
            car3 = carSet_images[random_num2];
        }else{
            car1 = carSet_images[random_num1];
            car2 = carSet_images[random_num2];
            car3 = carSet_images[random_num];
        }


        next_btn = findViewById(R.id.btn_next);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        img1.setImageResource(car1);
        img2.setImageResource(car2);
        img3.setImageResource(car3);

        car_type.setText(rndType);

        //set random image one
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timer){
                    count_timer.cancel();
                }
//                Toast.makeText(CarSelect.this, "Correct", Toast.LENGTH_LONG).show();
                if(answer == 0) {
                    correct_text.setVisibility(View.VISIBLE);
                    correct_text.setText("CORRECT !!!");
                    correct_text.setTextColor(Color.GREEN);
                    setClickableofImage();
                }else{
                    correct_text.setVisibility(View.VISIBLE);
                    correct_text.setText("WRONG !!!");
                    correct_text.setTextColor(Color.RED);
                    setClickableofImage();
                }
            }
        });

        //set random image two
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timer){
                    count_timer.cancel();
                }
                if(answer == 1) {
                    correct_text.setVisibility(View.VISIBLE);
                    correct_text.setText("CORRECT !!!");
                    correct_text.setTextColor(Color.GREEN);
                    setClickableofImage();
                }else{
                    correct_text.setVisibility(View.VISIBLE);
                    correct_text.setText("WRONG !!!");
                    correct_text.setTextColor(Color.RED);
                    setClickableofImage();
                }
            }
        });

        //set random image three
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timer){
                    count_timer.cancel();
                }

                if(answer == 2) {
                    correct_text.setVisibility(View.VISIBLE);
                    correct_text.setText("CORRECT !!!");
                    correct_text.setTextColor(Color.GREEN);
                    setClickableofImage();
                }else{
                    correct_text.setVisibility(View.VISIBLE);
                    correct_text.setText("WRONG !!!");
                    correct_text.setTextColor(Color.RED);
                    setClickableofImage();
                }

            }


        });

        //set next button
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Identify_Image.this, Identify_Image.class);
                intent.putExtra("time",timer);
                startActivity(intent);
                finish();


            }
        });
    }

    private void setClickableofImage() {
        img1.setClickable(false);
        img2.setClickable(false);
        img3.setClickable(false);
    }

}