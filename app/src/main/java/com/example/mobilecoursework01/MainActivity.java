package com.example.mobilecoursework01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch time_switch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time_switch  = findViewById(R.id.switch_btn);
    }
    //Data pass Identify car make activity
    public void Identify_Car_Make(View view){

        Intent intent = new Intent(this, Identify_Car.class);
        intent.putExtra("time", time_switch.isChecked());
        startActivity(intent);

    }
    //Data pass hint activity
    public void Hint(View view){

        Intent intent = new Intent(this, Hints.class);
        intent.putExtra("time", time_switch.isChecked());
        startActivity(intent);

    }

    //Data pass identify car image activity
    public void Identify_Car_Image(View view){

        Intent intent = new Intent(this, Identify_Image.class);
        intent.putExtra("time", time_switch.isChecked());
        startActivity(intent);

    }


    //Data pass advanced level activity
    public void Advanced_Level(View view){

        Intent intent = new Intent(this, Advanced_Level.class);
        intent.putExtra("time", time_switch.isChecked());
        startActivity(intent);

    }



}