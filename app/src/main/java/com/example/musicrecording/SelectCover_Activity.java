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

    ImageButton mood1;
    ImageButton mood2;
    ImageButton mood3;
    ImageButton mood4;
    ImageButton mood5;
    ImageButton mood6;
    ImageButton mood7;
    ImageButton mood8;



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
        mood1 = (ImageButton) findViewById(R.id.Btn_Mood1);
        mood2 = (ImageButton) findViewById(R.id.Btn_Mood2);
        mood3 = (ImageButton) findViewById(R.id.Btn_Mood3);
        mood4 = (ImageButton) findViewById(R.id.Btn_Mood4);
        mood5 = (ImageButton) findViewById(R.id.Btn_Mood5);
        mood6 = (ImageButton) findViewById(R.id.Btn_Mood6);
        mood7 = (ImageButton) findViewById(R.id.Btn_Mood7);
        mood8 = (ImageButton) findViewById(R.id.Btn_Mood8);
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
                break;

            case R.id.Btn_Personalimg:
                //갤러리에 접근하는 코드
                break;

            case R.id.Btn_Mood1:
                //이미지 체크표시
                mood1.setImageResource(R.drawable.clicked_covermood1);
                //다른 체크 삭제
                mood2.setImageResource(R.drawable.default_covermood2);
                mood3.setImageResource(R.drawable.default_covermood3);
                mood4.setImageResource(R.drawable.default_covermood4);
                mood5.setImageResource(R.drawable.default_covermood5);
                mood6.setImageResource(R.drawable.default_covermood6);
                mood7.setImageResource(R.drawable.default_covermood7);
                mood8.setImageResource(R.drawable.default_covermood8);
                break;


            case R.id.Btn_Mood2:
                //이미지 체크표시
                mood2.setImageResource(R.drawable.clicked_covermood2);
                //다른 체크 삭제
                mood1.setImageResource(R.drawable.default_covermood1);
                mood3.setImageResource(R.drawable.default_covermood3);
                mood4.setImageResource(R.drawable.default_covermood4);
                mood5.setImageResource(R.drawable.default_covermood5);
                mood6.setImageResource(R.drawable.default_covermood6);
                mood7.setImageResource(R.drawable.default_covermood7);
                mood8.setImageResource(R.drawable.default_covermood8);
                break;

            case R.id.Btn_Mood3:
                //이미지 체크표시
                mood3.setImageResource(R.drawable.clicked_covermood3);
                //다른 체크 삭제
                mood2.setImageResource(R.drawable.default_covermood2);
                mood1.setImageResource(R.drawable.default_covermood1);
                mood4.setImageResource(R.drawable.default_covermood4);
                mood5.setImageResource(R.drawable.default_covermood5);
                mood6.setImageResource(R.drawable.default_covermood6);
                mood7.setImageResource(R.drawable.default_covermood7);
                mood8.setImageResource(R.drawable.default_covermood8);
                break;

            case R.id.Btn_Mood4:
                //이미지 체크표시
                mood4.setImageResource(R.drawable.clicked_covermood4);
                //다른 체크 삭제
                mood2.setImageResource(R.drawable.default_covermood2);
                mood3.setImageResource(R.drawable.default_covermood3);
                mood1.setImageResource(R.drawable.default_covermood1);
                mood5.setImageResource(R.drawable.default_covermood5);
                mood6.setImageResource(R.drawable.default_covermood6);
                mood7.setImageResource(R.drawable.default_covermood7);
                mood8.setImageResource(R.drawable.default_covermood8);
                break;

            case R.id.Btn_Mood5:
                //이미지 체크표시
                mood5.setImageResource(R.drawable.clicked_covermood5);
                //다른 체크 삭제
                mood2.setImageResource(R.drawable.default_covermood2);
                mood3.setImageResource(R.drawable.default_covermood3);
                mood4.setImageResource(R.drawable.default_covermood4);
                mood1.setImageResource(R.drawable.default_covermood1);
                mood6.setImageResource(R.drawable.default_covermood6);
                mood7.setImageResource(R.drawable.default_covermood7);
                mood8.setImageResource(R.drawable.default_covermood8);
                break;

            case R.id.Btn_Mood6:
                //이미지 체크표시
                mood6.setImageResource(R.drawable.clicked_covermood6);
                //다른 체크 삭제
                mood2.setImageResource(R.drawable.default_covermood2);
                mood3.setImageResource(R.drawable.default_covermood3);
                mood4.setImageResource(R.drawable.default_covermood4);
                mood5.setImageResource(R.drawable.default_covermood5);
                mood1.setImageResource(R.drawable.default_covermood1);
                mood7.setImageResource(R.drawable.default_covermood7);
                mood8.setImageResource(R.drawable.default_covermood8);
                break;

            case R.id.Btn_Mood7:
                //이미지 체크표시
                mood7.setImageResource(R.drawable.clicked_covermood7);
                //다른 체크 삭제
                mood2.setImageResource(R.drawable.default_covermood2);
                mood3.setImageResource(R.drawable.default_covermood3);
                mood4.setImageResource(R.drawable.default_covermood4);
                mood5.setImageResource(R.drawable.default_covermood5);
                mood6.setImageResource(R.drawable.default_covermood6);
                mood1.setImageResource(R.drawable.default_covermood1);
                mood8.setImageResource(R.drawable.default_covermood8);
                break;

            case R.id.Btn_Mood8:
                //이미지 체크표시
                mood8.setImageResource(R.drawable.clicked_covermood8);
                //다른 체크 삭제
                mood2.setImageResource(R.drawable.default_covermood2);
                mood3.setImageResource(R.drawable.default_covermood3);
                mood4.setImageResource(R.drawable.default_covermood4);
                mood5.setImageResource(R.drawable.default_covermood5);
                mood6.setImageResource(R.drawable.default_covermood6);
                mood7.setImageResource(R.drawable.default_covermood7);
                mood1.setImageResource(R.drawable.default_covermood1);
                break;


       }

    }
}
