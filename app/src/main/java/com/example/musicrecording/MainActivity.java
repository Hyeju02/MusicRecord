package com.example.musicrecording;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Button Btn_WriteDiary = (Button) findViewById(R.id.Btn_WriteDiary);

        Btn_WriteDiary.setOnClickListener(this);
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