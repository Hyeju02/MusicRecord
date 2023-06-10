package com.example.musicrecording;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ShowDiaryActivity extends AppCompatActivity implements View.OnClickListener {
    //(오류)다이어리 화면에 표시된 Song, Singer Text 활용해 검색 키워드로 사용

    TextView songtextView;
    TextView singertextView;
    String songname;
    String singername;
    ImageButton Btn_PlayDiaryUrl;

    ImageView diarycover;
    String PlayUrl;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdiary_activity);

        //다이어리 커버사진
        diarycover = (ImageView)findViewById(R.id.ImageView_DiaryCover);

        //아이템 누른 것의 타이틀 정보 intent로 가져오기
        Intent it = getIntent();
        String str_title = it.getStringExtra("title");

        //텍스트뷰 스트링으로 가져오기(song, singer)
        songtextView = (TextView)findViewById(R.id.Text_Song);
        songtextView.setText(str_title); //타이틀 명 설정
        singertextView = (TextView)findViewById(R.id.Text_Singer);
        songname = songtextView.getText().toString();
        singername = singertextView.getText().toString();

        //유튜브 링크 재생 버튼
        Btn_PlayDiaryUrl = (ImageButton) findViewById(R.id.Btn_PlayDiaryUrl);
        Btn_PlayDiaryUrl.setOnClickListener(this);


/*
        //가져온 title 정보로 데이터베이스에서 검색하기
        DBManager dbmgr = new DBManager(this);
        SQLiteDatabase db = dbmgr.getReadableDatabase();
        String sql = "SELECT * FROM music WHERE title";
        String[] selectionArgs = { "%" + str_title + "%"};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        int i = 0;
        while (cursor.moveToNext()){

            String year = cursor.getString(0);
            String month = cursor.getString(1);
            String day = cursor.getString(2);
            String title = cursor.getString(3);
            String singer = cursor.getString(4);
            String mood = cursor.getString(5);
            String url = cursor.getString(6);
            String diary = cursor.getString(7);
            String cover = cursor.getString(8);


            singertextView.setText(singer);
            //사용자가 직접 링크를 입력한 경우
            PlayUrl = url;


            i++;


        }
        cursor.close();
        dbmgr.close();
*/
    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
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
                    Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse(PlayUrl));
                    startActivity(urlintent);
                    finish();
                }
                break;

        }
    }

}
