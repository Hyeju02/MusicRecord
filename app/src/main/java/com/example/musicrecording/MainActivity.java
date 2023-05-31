package com.example.musicrecording;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner;

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

    }

    @Override
    public void onClick(View v){


        switch (v.getId()) {
            case R.id.Btn_WriteDiary:
                Intent writediary = new Intent(this, WriteDiaryActivity.class);
                startActivity(writediary);
                finish();
                break;

            case R.id.Btn_MovetoSearch:
                Intent searchpage = new Intent(this, SearchActivity.class);
                startActivity(searchpage);
                finish();
                break;

        }


    }
}