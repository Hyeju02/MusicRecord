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
    //일단 다이어리 화면에 표시된 Song, Singer Text 활용해 검색 키워드로 사용
    TextView songtextView = (TextView)findViewById(R.id.Text_Song);
    TextView singertextView = (TextView)findViewById(R.id.Text_Singer);
    String songname = songtextView.getText().toString();
    String singername = singertextView.getText().toString();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdiary_activity);

        //유튜브 링크 재생 버튼
        ImageButton Btn_PlayDiaryUrl = (ImageButton) findViewById(R.id.Btn_PlayDiaryUrl);
        Btn_PlayDiaryUrl.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            //재생버튼 키워드(노래+가수) 검색된 유튜브 화면 열기
            case R.id.Btn_PlayDiaryUrl:
                Toast.makeText(getApplicationContext(), "Show you video", Toast.LENGTH_LONG).show();
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + songname + " " + singername));
                startActivity(urlintent);
                finish();
        }
    }

}
