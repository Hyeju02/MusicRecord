package com.example.musicrecording;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ShowDiaryActivity extends AppCompatActivity implements View.OnClickListener {
    //(오류)다이어리 화면에 표시된 Song, Singer Text 활용해 검색 키워드로 사용

    TextView songtextView;
    TextView singertextView;

    TextView textmood;
    TextView date;

    TextView diarycontext;

    String songname;
    String singername;
    ImageButton Btn_PlayDiaryUrl;

    ImageView diarycover;
    String PlayUrl;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdiary_activity);

        //버튼들
        ImageButton Btn_BackHome = (ImageButton) findViewById(R.id.Btn_BF_toHome2);
        Btn_BackHome.setOnClickListener(this);


        //다이어리 커버사진
        diarycover = (ImageView)findViewById(R.id.ImageView_DiaryCover);

        //아이템 누른 것의 타이틀 정보 intent로 가져오기
        Intent it = getIntent();
        String str_title = it.getStringExtra("selecttitle");

        //텍스트뷰 스트링으로 가져오기(song, singer)
        songtextView = (TextView)findViewById(R.id.Text_Song);
        songtextView.setText(str_title); //타이틀 명 설정
        singertextView = (TextView)findViewById(R.id.Text_Singer);
        songname = songtextView.getText().toString();
        textmood = (TextView) findViewById(R.id.Text_MoodofDiary);
        date = (TextView)findViewById(R.id.Text_DateofDiary);
        diarycontext = (TextView)findViewById(R.id.Text_Diary);






        //유튜브 링크 재생 버튼
        Btn_PlayDiaryUrl = (ImageButton) findViewById(R.id.Btn_PlayDiaryUrl);
        Btn_PlayDiaryUrl.setOnClickListener(this);


        //가져온 title 정보로 데이터베이스에서 검색하기
        int i = 0;
        try {
            DBManager dbmgr = new DBManager(this);
            SQLiteDatabase db = dbmgr.getReadableDatabase();
            String sql = "SELECT * FROM music WHERE title LIKE ?";
            String[] selectionArgs = {songname};
            Cursor cursor = db.rawQuery(sql, selectionArgs);

            while (cursor.moveToNext()){

                String year = cursor.getString(0);
                String month = cursor.getString(1);
                String day = cursor.getString(2);
                String title = cursor.getString(3);
                String singer = cursor.getString(4);
                String mood = cursor.getString(5);
                String url = cursor.getString(6);
                String diary = cursor.getString(7);
                int cover = cursor.getInt(8);


                singertextView.setText(singer);
                date.setText(year + ":" + month + ":" + day);
                textmood.setText(mood);
                diarycontext.setText(diary);

                //사용자가 직접 링크를 입력한 경우
                PlayUrl = url;
                //커버 사진 연결
                if (cover == 1){
                    diarycover.setImageResource(R.drawable.default_covermood1);
                } else if (cover == 2) {
                    diarycover.setImageResource(R.drawable.default_covermood2);
                } else if (cover == 3) {
                    diarycover.setImageResource(R.drawable.default_covermood3);
                } else if (cover == 4) {
                    diarycover.setImageResource(R.drawable.default_covermood4);
                } else if (cover == 5) {
                    diarycover.setImageResource(R.drawable.default_covermood5);
                } else if (cover == 6) {
                    diarycover.setImageResource(R.drawable.default_covermood6);
                } else if (cover == 7) {
                    diarycover.setImageResource(R.drawable.default_covermood7);
                } else if (cover == 8) {
                    diarycover.setImageResource(R.drawable.default_covermood8);
                } else if (cover == 0) {
                    //만약 사용자가 커버사진을 선택하지 않았을 때
                    //무드에 따라 임의로 지정
                    if (mood.equals("Happy") ){
                        diarycover.setImageResource(R.drawable.default_covermood1);
                    }
                    else if (mood.equals("Mellow")){
                        diarycover.setImageResource(R.drawable.default_covermood2);
                    }
                    else if (mood.equals("SO-SO")){
                        diarycover.setImageResource(R.drawable.default_covermood3);
                    }
                    else if (mood.equals("Sorrow")){
                        diarycover.setImageResource(R.drawable.default_covermood5);
                    }
                    else if (mood.equals("Gloomy")){
                        diarycover.setImageResource(R.drawable.default_covermood6);
                    }
                    else if (mood.equals("Mad")){
                        diarycover.setImageResource(R.drawable.default_covermood8);
                    }
                }


                i++;


            }
            cursor.close();
            dbmgr.close();
        }catch (SQLiteException e){

        }

        singername = singertextView.getText().toString();
    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.Btn_BF_toHome2:
                onBackPressed();
                finish();
                break;

            case R.id.Btn_PlayDiaryUrl:
                //만약 사용자가 직접 url을 넣지 않았다면
                if (PlayUrl == null){
                    //스트링 검색어로 넣은 유튜브 창 열기(노래 제목 + 가수 이름 검색된 화면)
                    Toast.makeText(getApplicationContext(), "Show you video", Toast.LENGTH_LONG).show();
                    Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + songname + " " + singername));
                    startActivity(urlintent);
                    finish();
                }
                //직접 url을 입력한 사용자라면
                else {
                    Intent urlintent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + PlayUrl));
                    startActivity(urlintent1);
                    finish();
                }
                break;

        }
    }

}
