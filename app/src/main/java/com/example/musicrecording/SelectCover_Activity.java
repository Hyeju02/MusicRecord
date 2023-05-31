package com.example.musicrecording;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toolbar;


public class SelectCover_Activity extends Activity implements View.OnClickListener {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcoverimg_activity);

        //다이어리 쓰는 곳으로 돌아가는 이전 버튼
        ImageButton Btn_ToWriteDiary = (ImageButton) findViewById(R.id.Btn_BF_toWriteDiary);
        Btn_ToWriteDiary.setOnClickListener(this);

        //갤러리에 접근하는 버튼
        ImageButton Btn_Personalimg = (ImageButton) findViewById(R.id.Btn_Personalimg);
        Btn_Personalimg.setOnClickListener(this);

        //무드 버튼들
        ImageButton mood1 = (ImageButton) findViewById(R.id.Btn_Mood1);
        ImageButton mood2 = (ImageButton) findViewById(R.id.Btn_Mood2);
        ImageButton mood3 = (ImageButton) findViewById(R.id.Btn_Mood3);
        ImageButton mood4 = (ImageButton) findViewById(R.id.Btn_Mood4);
        ImageButton mood5 = (ImageButton) findViewById(R.id.Btn_Mood5);
        ImageButton mood6 = (ImageButton) findViewById(R.id.Btn_Mood6);
        ImageButton mood7 = (ImageButton) findViewById(R.id.Btn_Mood7);
        ImageButton mood8 = (ImageButton) findViewById(R.id.Btn_Mood8);
        mood1.setOnClickListener(this);
        mood2.setOnClickListener(this);
        mood3.setOnClickListener(this);
        mood4.setOnClickListener(this);
        mood5.setOnClickListener(this);
        mood6.setOnClickListener(this);
        mood7.setOnClickListener(this);
        mood8.setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.Btn_BF_toWriteDiary:
                onBackPressed();
                finish();
                break;

            case R.id.Btn_Personalimg:
                //갤러리에 접근하는 코드
                break;

            case R.id.Btn_Mood1:
                //이미지 체크표시


       }

    }
}
