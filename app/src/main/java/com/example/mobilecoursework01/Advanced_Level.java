package com.example.mobilecoursework01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Advanced_Level extends AppCompatActivity {

    private int attemptcounter = 0;
    private int attemptcountTotal;
   // private int score;
    private boolean answered;
    String matchingnumbers = "Congratulations!";


    ImageView car1,car2,car3;

    int[] carSet_images;
    String[] img_Types;
    int rnd_no,rnd_no1,rnd_no2;
    int car_Image1,car_Image2,car_Image3;
    String car_Text1,car_Text2,car_Text3;
    EditText Etext1,Etext2,Etext3;
    TextView correct_wrong_txt,ans,ans1,scoret,attempts,ans2,ans3,ans4,ans5,txtview;
    Button submit_btn;
    String word;
    boolean timer;
    TextView  countdowntxt;
    CountDownTimer   count_timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced__level);

        //set title
        setTitle("Advanced Level");

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
        img_Types = new String[]{"suzuki", "toyota", "audi", "toyota", "suzuki","mercedes","perodua", "bmw", "bmw", "bmw", "toyota","suzuki", "toyota", "suzuki", "honda", "honda",
                "honda", "honda", "honda", "honda", "suzuki","nissan", "nissan", "toyota", "toyota", "nissan","honda", "toyota", "perodua", "nissan", "toyota"};


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
                    attemptcounter = 2;
                    submit_btn.callOnClick();
                    attempts.setText("3/3 Attempts");
                    txtview.setText("Times Up");
                    Etext1.setFocusable(false);
                    Etext2.setFocusable(false);
                    Etext3.setFocusable(false);
                    submit_btn.setText("Next");

                    if (Etext1.getText().toString().toLowerCase().equals(car_Text1)) {
                        Etext1.setTextColor(Color.GREEN);
                        Etext1.setEnabled(false);
                      //  correct_count++;

                    } else {
                        Etext1.setTextColor(Color.RED);
                        if(attemptcounter == 3){
                            ans.setVisibility(View.VISIBLE);
                            ans1.setVisibility(View.VISIBLE);
                            ans1.setText(car_Text1);
                        }
                    }

                    if (Etext2.getText().toString().toLowerCase().equals(car_Text2)) {
                        Etext2.setTextColor(Color.GREEN);
                        Etext2.setEnabled(false);
                     //   correct_count++;
                    } else {
                        Etext2.setTextColor(Color.RED);
                        if(attemptcounter == 3){
                            ans2.setVisibility(View.VISIBLE);
                            ans3.setVisibility(View.VISIBLE);
                            ans3.setText(car_Text2);
                        }
                    }

                    if (Etext3.getText().toString().toLowerCase().equals(car_Text3)) {
                        Etext3.setTextColor(Color.GREEN);
                        Etext3.setEnabled(false);
                       // correct_count++;
                    } else {
                        Etext3.setTextColor(Color.RED);
                        if(attemptcounter == 3){
                            ans4.setVisibility(View.VISIBLE);
                            ans5.setVisibility(View.VISIBLE);
                            ans5.setText(car_Text3);
                        }
                    }
                }
            }.start();
        }

        submit_btn = findViewById(R.id.sub_btn);
        car1 = findViewById(R.id.image1);
        car2 = findViewById(R.id.image2);
        car3 = findViewById(R.id.image3);

        correct_wrong_txt = findViewById(R.id.correct_txt);

        Etext1 = findViewById(R.id.image1_etxt);
        Etext2 = findViewById(R.id.image2_etxt);
        Etext3 = findViewById(R.id.image3_etxt);

        ans = findViewById(R.id.answer1);
        ans1 = findViewById(R.id.answer2);
        ans2 = findViewById(R.id.answer3);
        ans3= findViewById(R.id.answer4);
        ans4 = findViewById(R.id.answer5);
        ans5 = findViewById(R.id.answer6);

        scoret=findViewById(R.id.score_txt);
        attempts=findViewById(R.id.attempts_txt);
        txtview=(findViewById(R.id.textView));


        Random rand = new Random();
        rnd_no = rand.nextInt(carSet_images.length);
        word = img_Types[rnd_no];

        boolean selectone = false;

        while(!selectone) {
            rnd_no1 = rand.nextInt(carSet_images.length);
            if(rnd_no1 != rnd_no){
                selectone = true;
            }
        }

        boolean selecttwo = false;

        while(!selecttwo) {
            rnd_no2 = rand.nextInt(carSet_images.length);
            if(rnd_no2 != rnd_no && (rnd_no1 != rnd_no2)){
                selecttwo = true;
            }
        }

        car_Image1 = carSet_images[rnd_no];
        car_Image2 = carSet_images[rnd_no1];
        car_Image3 = carSet_images[rnd_no2];

        car_Text1 =  img_Types[rnd_no];
        car_Text2 =  img_Types[rnd_no1];
        car_Text3 =  img_Types[rnd_no2];

        car1.setImageResource(car_Image1);
        car2.setImageResource(car_Image2);
        car3.setImageResource(car_Image3);

        //set submit button action
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!submit_btn.getText().equals("Next")) {
                    attemptcounter ++;
                    int correct_count = 0;
                    if (!Etext1.getText().toString().isEmpty() || !Etext2.getText().toString().isEmpty() || !Etext3.getText().toString().isEmpty()) {
                        if (Etext1.getText().toString().toLowerCase().equals(car_Text1)) {
                            Etext1.setTextColor(Color.GREEN);
                            Etext1.setEnabled(false);
                            correct_count++;

                        } else {
                            Etext1.setTextColor(Color.RED);
                            if(attemptcounter == 3){
                                ans.setVisibility(View.VISIBLE);
                                ans1.setVisibility(View.VISIBLE);
                                ans1.setText(car_Text1);
                            }
                        }

                        if (Etext2.getText().toString().toLowerCase().equals(car_Text2)) {
                            Etext2.setTextColor(Color.GREEN);
                            Etext2.setEnabled(false);
                            correct_count++;
                        } else {
                            Etext2.setTextColor(Color.RED);
                            if(attemptcounter == 3){
                                ans2.setVisibility(View.VISIBLE);
                                ans3.setVisibility(View.VISIBLE);
                                ans3.setText(car_Text2);
                            }
                        }

                        if (Etext3.getText().toString().toLowerCase().equals(car_Text3)) {
                            Etext3.setTextColor(Color.GREEN);
                            Etext3.setEnabled(false);
                            correct_count++;
                        } else {
                            Etext3.setTextColor(Color.RED);
                            if(attemptcounter == 3){
                                ans4.setVisibility(View.VISIBLE);
                                ans5.setVisibility(View.VISIBLE);
                                ans5.setText(car_Text3);
                            }
                        }

                        if (correct_count == 3) {
                            submit_btn.setText("Next");
                            correct_wrong_txt.setVisibility(View.VISIBLE);

                            Toast.makeText(getApplicationContext(), matchingnumbers, Toast.LENGTH_LONG).show();
                            scoret.setText("Score: 3");

                        } else {
                            correct_wrong_txt.setVisibility(View.GONE);

                            scoret.setText("Score: "+ correct_count);
                        }
                        if(attemptcounter ==3) {
                            submit_btn.setText("Next");
                            attempts.setText("3/3 Attempts");


                        }else{
                            attempts.setText(attemptcounter+"/3 Attempts");
                        }
                    } else {
                        if (Etext1.getText().toString().isEmpty()) {
                            Toast.makeText(Advanced_Level.this, "Should Enter an Answer for Image 1", Toast.LENGTH_LONG).show();
                        } else if (Etext2.getText().toString().isEmpty()) {
                            Toast.makeText(Advanced_Level.this, "Should Enter an Answer for Image 2", Toast.LENGTH_LONG).show();
                        } else if (Etext3.getText().toString().isEmpty()) {
                            Toast.makeText(Advanced_Level.this, "Should Enter an Answer for Image 3", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Intent intent = new Intent(Advanced_Level.this, Advanced_Level.class);
                    intent.putExtra("time",timer);
                    startActivity(intent);
                    finish();
                }
            }
        });



    }


}