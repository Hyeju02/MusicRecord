package com.example.musicrecording;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner;
    Spinner spinnermood;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //다이어리 새로 작성하는 버튼
        ImageButton Btn_WriteDiary = (ImageButton) findViewById(R.id.Btn_WriteDiary);
        Btn_WriteDiary.setOnClickListener(this);

        //검색 버튼
        ImageButton Btn_search = (ImageButton) findViewById(R.id.Btn_MovetoSearch);
        Btn_search.setOnClickListener(this);

        //무드 혹은 달 고르는 스피너
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.array_moodormonth, android.R.layout.simple_dropdown_item_1line
        );
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner = (Spinner)findViewById(R.id.Spinner_MoodorMonth);
        spinner.setAdapter(adapter);

        //무드 선택하면 무드 스피너, 달 선택하면 달 스피너
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this,R.array.array_selectmood, android.R.layout.simple_dropdown_item_1line
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnermood = (Spinner)findViewById(R.id.Spinner_SelectMoodorMonth);
        spinnermood.setAdapter(adapter1);

    }

    @Override
    public void onClick(View v){


        switch (v.getId()) {
            case R.id.Btn_WriteDiary:
                Intent writediary = new Intent(this, WriteDiaryActivity.class);
                startActivity(writediary);
                break;

            case R.id.Btn_MovetoSearch:
                Intent searchpage = new Intent(this, SearchActivity.class);
                startActivity(searchpage);
                break;

            case R.id.Spinner_SelectMoodorMonth:
                //스피너에서 mood를 골랐을 때
                //안 돌아감...
                if (spinner.getSelectedItem().toString() == "Month"){
                    Toast message = Toast.makeText(getApplicationContext(),"클릭됨",Toast.LENGTH_LONG);
                    message.show();

                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            this,R.array.array_selectmonth, android.R.layout.simple_dropdown_item_1line
                    );
                    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    spinnermood = (Spinner)findViewById(R.id.Spinner_SelectMoodorMonth);
                    spinnermood.setAdapter(adapter);


                }
                break;
        }


    }
}