package com.example.musicrecording;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class WriteDiaryActivity extends Activity implements View.OnClickListener {

    Spinner spinner;
    //private DBManager dbmgr;
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.writediary_activity);

        //홈화면으로 돌아가는 버튼
        Button Btn_BF_toHome = (Button) findViewById(R.id.Btn_BF_toHome);
        Btn_BF_toHome.setOnClickListener(this);

        //무드 고르는 스피너
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.array_selectmood, android.R.layout.simple_dropdown_item_1line
        );
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner = (Spinner)findViewById(R.id.Spinner_SelectMood);
        spinner.setAdapter(adapter);


    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.Btn_BF_toHome:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
        }
    }
}
