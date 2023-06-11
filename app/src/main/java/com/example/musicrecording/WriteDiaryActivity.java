package com.example.musicrecording;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class WriteDiaryActivity extends Activity implements View.OnClickListener {

    Spinner spinner;
    private DBManager dbmgr;
    int showcover = 0;
    int str_cover;
    String str_dateyy;
    String str_datemm;
    String str_datedd;
    String str_title;
    String str_singer;
    String str_url;
    String str_diary;
    String str_mood;

    EditText et_dateyy;
    EditText et_datemm;
    EditText et_datedd;
    EditText et_title;
    EditText et_singer;
    EditText et_diary;
    EditText et_url;
    String et_mood;

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

        //입력창
         et_dateyy = (EditText)findViewById(R.id.Edit_addyy);
         et_datemm = (EditText)findViewById(R.id.Edit_addmm);
         et_datedd = (EditText)findViewById(R.id.Edit_adddd);
         et_title = (EditText) findViewById(R.id.Edit_Song);
         et_singer = (EditText)findViewById(R.id.Edit_Singer);
         et_url = (EditText)findViewById(R.id.Edit_Url);
         et_diary = (EditText)findViewById(R.id.Edit_Diary);
         et_mood = spinner.getSelectedItem().toString();




        //커버 미니 이미지뷰
        ImageView minicover;
        minicover = (ImageView)findViewById(R.id.Imageview_minicover);

        //여태 입력한 값 다시 받아오기
        Intent intent = getIntent();
        str_dateyy = intent.getStringExtra("dateyy");
        str_datemm = intent.getStringExtra("datemm");
        str_datedd = intent.getStringExtra("datedd");
        str_title = intent.getStringExtra("title");
        str_singer = intent.getStringExtra("singer");
        str_url = intent.getStringExtra("url");
        str_diary = intent.getStringExtra("diary");
        str_mood = intent.getStringExtra("mood");
        int spinnerposition = adapter.getPosition(str_mood);

        et_dateyy.setText(str_dateyy);
        et_datemm.setText(str_datemm);
        et_datedd.setText(str_datedd);
        et_title.setText(str_title);
        et_singer.setText(str_singer);
        et_url.setText(str_url);
        et_diary.setText(str_diary);
        spinner.setSelection(spinnerposition);


        //커버 셀렉한 값 받기
        showcover = intent.getIntExtra("cover", 0);

        //셀렉 값에 따라 컬러 표시
        if (showcover == 1){
            minicover.setImageResource(R.drawable.default_covermood1);
        }
        else if (showcover == 2){
            minicover.setImageResource(R.drawable.default_covermood2);
        }
        else if (showcover == 3){
            minicover.setImageResource(R.drawable.default_covermood3);
        }
        else if (showcover == 4){
            minicover.setImageResource(R.drawable.default_covermood4);
        }
        else if (showcover == 5){
            minicover.setImageResource(R.drawable.default_covermood5);
        }
        else if (showcover == 6){
            minicover.setImageResource(R.drawable.default_covermood6);
        }
        else if (showcover == 7){
            minicover.setImageResource(R.drawable.default_covermood7);
        }
        else if (showcover == 8){
            minicover.setImageResource(R.drawable.default_covermood8);
        }
        else{
            minicover.setImageResource(R.drawable.default_minicover);
        }


    }

    public void onClick(View v){

        //(0531)날짜 수정
        //년
        String str_dateyy = et_dateyy.getText().toString();
        //월
        String str_datemm = et_datemm.getText().toString();
        //일
        String str_datedd = et_datedd.getText().toString();

        String str_title = et_title.getText().toString();

        String str_singer = et_singer.getText().toString();

        String str_url = et_url.getText().toString();

        String str_diary = et_diary.getText().toString();

        et_mood = spinner.getSelectedItem().toString();
        String str_mood = et_mood;

        str_cover = showcover;


        dbmgr = new DBManager(this);
        SQLiteDatabase sdb;
        sdb = dbmgr.getWritableDatabase();



        switch (v.getId()){
            case R.id.Btn_BF_toHome:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
                break;

            case R.id.Btn_SelectCover:
                Intent cover = new Intent(this, SelectCover_Activity.class);
                cover.putExtra("dateyy", str_dateyy);
                cover.putExtra("datemm", str_datemm);
                cover.putExtra("datedd", str_datedd);
                cover.putExtra("title", str_title);
                cover.putExtra("singer", str_singer);
                cover.putExtra("url", str_url);
                cover.putExtra("diary", str_diary);
                cover.putExtra("mood", str_mood);
                cover.putExtra("cover", str_cover);

                startActivity(cover);
                break;


            case R.id.Btn_SaveDiary:
                try {
                    if (str_title.isEmpty() || str_singer.isEmpty()) {
                        Toast caution = Toast.makeText(getApplicationContext(),"노래 제목과 가수 이름을 기록해주세요.",Toast.LENGTH_LONG);
                        caution.show();
                        break;
                    } else {
                        //(0531)execSQL str_date에서 str_dateyy, datemm, datedd로 수정
                        sdb.execSQL("insert into music values('" +str_dateyy+ "', '" +str_datemm+ "', '" +str_datedd+ "', '" +str_title+ "','" +str_singer+ "','" +str_mood+ "','" +str_url+ "','" +str_diary+ "','" +str_cover+ "');");
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
