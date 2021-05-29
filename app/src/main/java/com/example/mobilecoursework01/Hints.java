package com.example.mobilecoursework01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Hints extends AppCompatActivity {



    private Spinner spinner;
    ImageView car_images;
    int[] carSet_img;
    String[] car_Types;
    int random_no = 0;
    String word;
    TextView guess_name,let,CountDown;
    String wordtext = "";
    int wrongCount = 0;
    Button guess_btn;
    TextView correct_text,reply1,reply2;
    CountDownTimer count_timer;
    private TextView countdowntxt;
    boolean timer = false;
    boolean onStart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hints);

        //set title
        setTitle("Hints");



        //set images
                carSet_img = new int[]{
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
        car_Types = new String[]{"SUZUKI", "TOYOTA", "AUDI", "TOYOTA", "SUZUKI","MERCEDES","PERODUA", "BMW", "BMW", "BMW", "TOYOTA","SUZUKI", "TOYOTA", "SUZUKI", "HONDA", "HONDA",
                "HONDA", "HONDA", "HONDA", "HONDA", "SUZUKI","NISSAN", "NISSAN", "TOYOTA", "TOYOTA", "NISSAN","HONDA", "TOYOTA", "PERODUA", "NISSAN", "TOYOTA"};

        //set countdown timer
        timer = getIntent().getBooleanExtra("time",false);
        countdowntxt = findViewById(R.id.countdown_timer);
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

                    let.setFocusable(false);
                    guess_btn.setText("NEXT");


                    String letter = let.getText().toString();
                    if (let.getText().length() <= 0) {
                        if (!wordtext.contains("_")) {

                            correct_text.setVisibility(View.VISIBLE);
                            correct_text.setText("CORRECT!!!");
                            correct_text.setTextColor(Color.GREEN);
                            guess_btn.setText("NEXT");
                        } else {
                            wrongCount = 3;
                            if (wrongCount >= 3) {
                                correct_text.setVisibility(View.VISIBLE);
                                reply1.setVisibility(View.VISIBLE);
                                reply2.setVisibility(View.VISIBLE);
                                correct_text.setText("WRONG!!!");
                                correct_text.setTextColor(Color.RED);
                                reply1.setText(word);
                                guess_btn.setText("NEXT");

                            }

                        }
                    } else {

                    if (word.contains(letter)) {
                        for (int i = 0; i < word.length(); i++) {
                            if ((word.charAt(i)) == letter.charAt(0)) {

                                char[] myNameChars = wordtext.toCharArray();
                                myNameChars[i * 2] = letter.charAt(0);
                                wordtext = String.valueOf(myNameChars);
                            }
                        }

                        guess_name.setText(wordtext);


                        if (!wordtext.contains("_")) {

                            correct_text.setVisibility(View.VISIBLE);
                            correct_text.setText("CORRECT!!!");
                            correct_text.setTextColor(Color.GREEN);
                            guess_btn.setText("NEXT");
                        }


                    } else {
                        wrongCount = 3;
                        if (wrongCount >= 3) {
                            correct_text.setVisibility(View.VISIBLE);
                            reply1.setVisibility(View.VISIBLE);
                            reply2.setVisibility(View.VISIBLE);
                            correct_text.setText("WRONG!!!");
                            correct_text.setTextColor(Color.RED);
                            reply1.setText(word);
                            guess_btn.setText("NEXT");


                        }
                    }
                    }
                }
            }.start();
        }


        //set random images
        Random rand = new Random();

        correct_text = findViewById(R.id.correct_txt);
        reply1= findViewById(R.id.answ1);
        reply2 = findViewById(R.id.answ2);

        guess_btn = findViewById(R.id.sub_btn);

        guess_name = findViewById(R.id.guess_txt);
        let = findViewById(R.id.E_txt);

        random_no = rand.nextInt(carSet_img.length);
        word = car_Types[random_no];
        car_images = findViewById(R.id.image);
        car_images.setImageResource(carSet_img[random_no]);



        //set word text length
        for(int i=0;i<word.length();i++){
            wordtext = wordtext + "_ ";
        }

        guess_name.setText(wordtext);

        //set submit button action and next button action
        guess_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!guess_btn.getText().equals("NEXT")) {
                    if (let.getText().length() <= 0) {
                        Toast.makeText(Hints.this, "Should Enter a Letter", Toast.LENGTH_SHORT).show();
                    } else {
                        String letter = let.getText().toString();

                        if (word.contains(letter)) {
                            for (int i = 0; i < word.length(); i++) {
                                if ((word.charAt(i)) == letter.charAt(0)) {

                                    char[] myNameChars = wordtext.toCharArray();
                                    myNameChars[i * 2] = letter.charAt(0);
                                    wordtext = String.valueOf(myNameChars);
                                }
                            }

                            guess_name.setText(wordtext);


                            if (!wordtext.contains("_")) {

                                correct_text.setVisibility(View.VISIBLE);
                                correct_text.setText("CORRECT!!!");
                                correct_text.setTextColor(Color.GREEN);
                                guess_btn.setText("NEXT");

                                if(timer){
                                    count_timer.cancel();
                                }
                            }


                        } else {
                            wrongCount++;
                            if (wrongCount >= 3) {
                                correct_text.setVisibility(View.VISIBLE);
                                reply1.setVisibility(View.VISIBLE);
                                reply2.setVisibility(View.VISIBLE);
                                correct_text.setText("WRONG!!!");
                                correct_text.setTextColor(Color.RED);
                                reply1.setText(word);
                                guess_btn.setText("NEXT");
                                if(timer){
                                    count_timer.cancel();
                                }


                            }else {
                                Toast.makeText(Hints.this, "Wrong, You have another " + (3 - wrongCount) + " Guesses", Toast.LENGTH_SHORT).show();
                            }

                        }



                    }
                    let.setText("");

                } else {
                    Intent intent = new Intent(Hints.this, Hints.class);
                    intent.putExtra("time", timer);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

}