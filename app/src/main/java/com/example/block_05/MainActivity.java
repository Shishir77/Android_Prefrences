package com.example.block_05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences= getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        ConstraintLayout layout= (ConstraintLayout)findViewById(R.id.layout);
        RadioGroup radioGroup_colors =(RadioGroup)findViewById(R.id.radioGroup_colors);


        if(preferences.contains("colorID"))
        {
            layout.setBackgroundColor(preferences.getInt("colorID",0));
        }
        //when item is clicked

        radioGroup_colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int colorCode= 0;
                switch (checkedId) {

                    case R.id.radioButton_blue:
                       colorCode=Color.BLUE;
                        break;
                    case R.id.radioButton_red:
                        colorCode=Color.RED;
                        break;
                    case R.id.radioButton_yellow:
                        colorCode=Color.YELLOW;
                        break;
                }
                layout.setBackgroundColor(colorCode); //preferences
                editor.putInt("colorID",colorCode);
                editor.commit();
            }
        });


    }

}