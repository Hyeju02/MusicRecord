package com.example.musicrecording;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Button Btn_WriteDiary = (Button) findViewById(R.id.Btn_WriteDiary);
        Btn_WriteDiary.setOnClickListener(this);

        //무드 혹은 달 고르는 스피너
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.array_moodormonth, android.R.layout.simple_dropdown_item_1line
        );
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner = (Spinner)findViewById(R.id.Spinner_MoodorMonth);
        spinner.setAdapter(adapter);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.Btn_WriteDiary:
                Intent writediary = new Intent(this,WriteDiaryActivity.class);
                startActivity(writediary);

        }


    }
}