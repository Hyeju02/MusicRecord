package com.example.musicrecording;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdiary_activity);

        //텍스트뷰 스트링으로 가져오기(song, singer)
        songtextView = (TextView)findViewById(R.id.Text_Song);
        singertextView = (TextView)findViewById(R.id.Text_Singer);
        songname = songtextView.getText().toString();
        singername = singertextView.getText().toString();

        //유튜브 링크 재생 버튼
        Btn_PlayDiaryUrl = (ImageButton) findViewById(R.id.Btn_PlayDiaryUrl);
        Btn_PlayDiaryUrl.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.Btn_PlayDiaryUrl:
                //스트링 검색어로 넣은 유튜브 창 열기(노래 제목 + 가수 이름 검색된 화면)
                Toast.makeText(getApplicationContext(), "Show you video", Toast.LENGTH_LONG).show();
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + songname + " " + singername));
                startActivity(urlintent);
                finish();
        }
    }

}
