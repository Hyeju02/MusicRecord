package com.example.musicrecording;

import android.app.Activity;
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
import android.widget.Toast;

import java.util.ArrayList;

public class WriteDiaryActivity extends Activity implements View.OnClickListener {

    Spinner spinner;
    private DBManager dbmgr;
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.writediary_activity);

        //홈화면으로 돌아가는 버튼
        ImageButton Btn_BF_toHome = (ImageButton) findViewById(R.id.Btn_BF_toHome);
        Btn_BF_toHome.setOnClickListener(this);

        //커버 고르는 엑티비티로 넘어가는 버튼
        ImageButton Btn_cover = (ImageButton) findViewById(R.id.Btn_SelectCover);
        Btn_cover.setOnClickListener(this);

        //저장하는 버튼
        ImageButton Btn_Save = (ImageButton)findViewById(R.id.Btn_SaveDiary);
        Btn_Save.setOnClickListener(this);


        //무드 고르는 스피너
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.array_selectmood, android.R.layout.simple_dropdown_item_1line
        );
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner = (Spinner)findViewById(R.id.Spinner_SelectMood);
        spinner.setAdapter(adapter);


    }

    public void onClick(View v){

        //날짜
        EditText et_date = (EditText)findViewById(R.id.Edit_adddate);
        String str_date = et_date.getText().toString();

        EditText et_title = (EditText) findViewById(R.id.Edit_Song);
        String str_title = et_title.getText().toString();

        EditText et_singer = (EditText)findViewById(R.id.Edit_Singer);
        String str_singer = et_singer.getText().toString();

        EditText et_url = (EditText)findViewById(R.id.Edit_Url);
        String str_url = et_url.getText().toString();

        EditText et_diary = (EditText)findViewById(R.id.Edit_Diary);
        String str_diary = et_diary.getText().toString();

        String str_mood = spinner.getSelectedItem().toString();

        dbmgr = new DBManager(this);
        SQLiteDatabase sdb;
        sdb = dbmgr.getWritableDatabase();



        switch (v.getId()){
            case R.id.Btn_BF_toHome:
                onBackPressed();
                break;

            case R.id.Btn_SelectCover:
                Intent cover = new Intent(this, SelectCover_Activity.class);
                startActivity(cover);
                break;

            case R.id.Btn_SaveDiary:
                try {
                    if (str_title.isEmpty() || str_singer.isEmpty()) {
                        Toast caution = Toast.makeText(getApplicationContext(),"노래 제목과 가수 이름을 기록해주세요.",Toast.LENGTH_LONG);
                        caution.show();
                        break;
                    } else {
                        sdb.execSQL("insert into music values('" + str_date + "','" + str_title + "','" + str_singer + "','" + str_mood + "','" + str_url + "','" + str_diary + "';");
                        dbmgr.close();

                        Intent it = new Intent(this, MainActivity.class);
                        startActivity(it);
                        finish();
                        break;
                    }
                }catch (SQLException e){}

        }
    }
}
